package com.liqy.neihan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.liqy.neihan.Adapter.HomeAReAdapter;
import com.liqy.neihan.R;
import com.liqy.neihan.View.IView;
import com.liqy.neihan.bean.Mvpbean;
import com.liqy.neihan.presenter.Presenter;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 杨洪 on 2018/1/9.
 */

public class ContentFragment extends Fragment implements IView {

    private AVLoadingIndicatorView avi;
    private RecyclerView recyclerview;
    private AVLoadingIndicatorView avi_loadmore;
    private LinearLayout layout_loadmore;
    private SwipeRefreshLayout swiperedreshlayout;
    private HomeAReAdapter homeAReAdapter;
    private Presenter presenter;
    private List<Mvpbean.DataBeanX.DataBean> list;
    private LinearLayoutManager manager;
    ArrayList<Mvpbean.DataBeanX.DataBean> dataBeans = new ArrayList<>();
    private String ss;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.content, null);
        initView(view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

   //http://lf.snssdk.com/neihan/stream/mix/v1/?content_type=-101     推荐
  //http://lf.snssdk.com/neihan/stream/mix/v1/?content_type=-104    视频
        //http://lf.snssdk.com/neihan/stream/mix/v1/?content_type=-103  图片
        //http://lf.snssdk.com/neihan/stream/mix/v1/?content_type=-102   段子
        //http://lf.snssdk.com/neihan/in_app/mybar_list/       订阅
        //http://lf.snssdk.com/neihan/stream/mix/v1/?content_type=-201  同城
        //http://lf.snssdk.com/neihan/dongtai/dongtai_list/v1/    段友圈


        Bundle bundle=getArguments();
        String url = bundle.getString("url");
        String name = bundle.getString("name");
        if(name.equals("推荐")||(name.equals("视频"))||(name.equals("图片"))||(name.equals("同城"))||(name.equals("段子")))
        {

            String[] split = url.split("-");
            String s = split[1];
            ss = "-"+s;
            Toast.makeText(getActivity(), ""+name+s, Toast.LENGTH_SHORT).show();

        }

        //开启加载中动画
        startLoading();
        //布局管理器
        manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        homeAReAdapter = new HomeAReAdapter(getActivity(),dataBeans);
        //recyclerview设置
        recyclerview.setLayoutManager(manager);
        recyclerview.setAdapter(homeAReAdapter);

        presenter = new Presenter(this);
         Map<String, String> map = new HashMap<>();
        map.put("content_type", ""+ss);
        presenter.getBaseurl("http://lf.snssdk.com/", map);

        //下拉刷新
        swiperedreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Map<String, String> map = new HashMap<>();
                map.put("content_type", "-101");
                presenter.getBaseurl("http://lf.snssdk.com/", map);
            }
        });
        //监听上拉加载更多
        recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
              if (dataBeans.size() < 1) {
                    return;
                }
                //如果正在下拉刷新则放弃监听状态
                if (swiperedreshlayout.isRefreshing()) {
                    return;
                }
                //当前RecyclerView显示出来的最后一个的item的position,默认为-1
                int lastPosition = -1;
                //当前状态为停止滑动状态SCROLL_STATE_IDLE时
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    //分别判断三种类型
                    if (layoutManager instanceof GridLayoutManager) {
                        //通过LayoutManager找到当前显示的最后的item的position
                        lastPosition = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
                    } else if (layoutManager instanceof LinearLayoutManager) {
                        lastPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                    } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                        //因为StaggeredGridLayoutManager的特殊性可能导致最后显示的item存在多个，所以这里取到的是一个数组
                        //得到这个数组后再取到数组中position值最大的那个就是最后显示的position值了
                        int[] lastPositions = new int[((StaggeredGridLayoutManager) layoutManager).getSpanCount()];
                        ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(lastPositions);
                        lastPosition = findMax(lastPositions);
                    }
                    // 判断界面显示的最后item的position是否等于itemCount总数-1也就是最后一个item的position
                    //如果相等则说明已经滑动到最后了
                    if (lastPosition == recyclerView.getLayoutManager().getItemCount() - 1) {
                        startLoadingMore();
                        //此时需要请求等过数据，显示加载更多界面
                        Map<String, String> map = new HashMap<>();
                        map.put("content_type", "-101");
                        presenter.getBaseurl("http://lf.snssdk.com/", map);
                    }
                }
            }
        });
    }

    public int findMax(int[] lastPositions) {
        int max = lastPositions[0];
        for (int value : lastPositions) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    /**
     * 开启加载中动画
     */
    public void startLoading() {
        avi.smoothToShow();
    }

    /**
     * 开启加载更多动画
     */
    public void startLoadingMore() {
        layout_loadmore.setVisibility(View.VISIBLE);
        avi_loadmore.smoothToShow();
    }

    /**
     * 关闭加载中动画
     */
    public void stopLoading() {
        if (avi.isShown()) {
            avi.smoothToHide();
        }
    }

    /**
     * 关闭加载更多动画
     */
    public void stopLoadingMore() {
        layout_loadmore.setVisibility(View.GONE);
        avi_loadmore.smoothToHide();
    }

    /**
     * 停止下拉刷新
     */
    public void stopRefreshing() {
        if (swiperedreshlayout.isRefreshing()) {
            swiperedreshlayout.setRefreshing(false);
        }
    }


    @Override
    public void onSuccess(Object o) {


    }

    @Override
    public void onFailed(Exception e) {

    }

    @Override
    public void onSuccessTab(Object o) {


        if (o != null) {
            Mvpbean mvpbean = (Mvpbean) o;
            if (mvpbean.getData() != null) {
                list = mvpbean.getData().getData();

                if (list != null) {
                    dataBeans.addAll(list);
                    homeAReAdapter.notifyDataSetChanged();
                    //关闭动画
                    stopLoading();
                    stopLoadingMore();
                    stopRefreshing();
                    Log.i("zzzzz", "chenggong");
                }
            }
        }
    }

    @Override
    public void onFailedTab(Exception e) {
        Log.i("zzzzz", "shibai");
    }


    private void initView(View view) {

        avi = (AVLoadingIndicatorView) view.findViewById(R.id.avi);
        recyclerview = (RecyclerView) view.findViewById(R.id.recyclerview);
        avi_loadmore = (AVLoadingIndicatorView) view.findViewById(R.id.avi_loadmore);
        layout_loadmore = (LinearLayout) view.findViewById(R.id.layout_loadmore);
        swiperedreshlayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperedreshlayout);
    }


}
