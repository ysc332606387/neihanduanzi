package com.liqy.neihan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.liqy.neihan.R;
import com.liqy.neihan.View.IView;
import com.liqy.neihan.bean.Bean;
import com.liqy.neihan.presenter.Presenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 杨洪 on 2018/1/9.
 */

public class HomePageFragment extends Fragment implements IView {

    private List<String> datas = new ArrayList<String>();
    private TabLayout tablayout;
    private ViewPager viewPager;
    private Presenter presenter;
    private List<Bean.DataBean> data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = View.inflate(getContext(), R.layout.homepage, null);
        initView(view);


        presenter = new Presenter(this);
        Map<String, String> map = new HashMap<>();
        presenter.get("http://lf.snssdk.com/", map);
        return view;


    }

    private void initView(View view) {
        tablayout = (TabLayout) view.findViewById(R.id.tablayout);
        viewPager = (ViewPager) view.findViewById(R.id.vp);

    }

    @Override
    public void onSuccess(Object o) {


        if (o != null) {


            Bean b = (Bean) o;

            if (b.getData() != null) {


                data = b.getData();
                for (int i = 0; i < data.size(); i++) {
                    String name = data.get(i).getName();
                    datas.add(name);
                    Log.i("datas", "" + datas.toString());

                }

                //设置加载页数data.size()
                viewPager.setOffscreenPageLimit(1);
                viewPager.setAdapter(new MyAdapter(getActivity().getSupportFragmentManager()));

                //进行关联
                tablayout.setupWithViewPager(viewPager);


            }


        }


    }

    @Override
    public void onFailed(Exception e) {

    }

    @Override
    public void onSuccessTab(Object o) {

    }

    @Override
    public void onFailedTab(Exception e) {

    }


    @Override
    public void onDetach() {
        super.onDetach();
        presenter.detatch();
    }

    class MyAdapter extends FragmentPagerAdapter {

        //带参的构造方法
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        //返回选项卡的文本 ，，，添加选项卡
        @Override
        public CharSequence getPageTitle(int position) {
            return datas.get(position);
        }

        @Override
        public Fragment getItem(int position) {

            //创建fragment对象并返回
            Bundle bundle = new Bundle();
            bundle.putString("url", data.get(position).getUrl());
            bundle.putString("name", data.get(position).getName());
            ContentFragment contentFragment = new ContentFragment();
            contentFragment.setArguments(bundle);

            return contentFragment;
        }

        @Override
        public int getCount() {
            return datas.size();//返回选项卡的数量
        }
    }
}





