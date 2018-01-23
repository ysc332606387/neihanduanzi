package com.liqy.neihan.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.liqy.neihan.R;
import com.liqy.neihan.bean.Mvpbean;
import com.wx.goodview.GoodView;

import org.w3c.dom.Text;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by 杨洪 on 2018/1/10.
 */

public class HomeAReAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Mvpbean.DataBeanX.DataBean> list;


    public HomeAReAdapter(Context context, List<Mvpbean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == 1) {

            View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;

        } else if (viewType == 2) {
            View view = LayoutInflater.from(context).inflate(R.layout.picitem, parent, false);
            ViewHolder2 holder = new ViewHolder2(view);
            return holder;


        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.tvitem, parent, false);
            ViewHolder3 holder = new ViewHolder3(view);
            return holder;


        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ViewHolder) {
            ViewHolder hold = (ViewHolder) holder;

            String mp4_url = list.get(position).getGroup().getMp4_url();
            String category_name = list.get(position).getGroup().getCategory_name();
            String cover_image_uri = list.get(position).getGroup().getCover_image_uri();


            //视屏上的图片
            Mvpbean.DataBeanX.DataBean.GroupBean.LargeCoverBean large_cover = list.get(position).getGroup().getLarge_cover();
            if (large_cover != null) {
                List<Mvpbean.DataBeanX.DataBean.GroupBean.LargeCoverBean.UrlListBeanXXX> url_list = large_cover.getUrl_list();
                if (url_list != null) {
                    String url = url_list.get(1).getUrl();

                    Glide.with(context).load(url).into(hold.jcVideoPlayerStandard.thumbImageView);
                }
            }


//视频
            if (mp4_url != "") {
                if (category_name != null) {

                    if (cover_image_uri != null) {
                        boolean setUp = hold.jcVideoPlayerStandard.setUp(mp4_url, JCVideoPlayer.SCREEN_LAYOUT_LIST, category_name);
                        if (setUp) {
                            hold.jcVideoPlayerStandard.thumbImageView.setScaleType(ImageView.ScaleType.FIT_XY);

                        }

                    }

                }


            }


            //标题
            GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(context.getResources());
            // 设置圆形图片
// 设置形状对象,形状为圆形
            RoundingParams params = RoundingParams.asCircle();
//创建设置参数,设置一个形状,把形状对象塞入
            GenericDraweeHierarchy roundness = builder.setRoundingParams(params).build();
//将参数对象设置给图片控件
            hold.sim_fre.setHierarchy(roundness);

//头像
            Mvpbean.DataBeanX.DataBean.GroupBean.UserBean user = list.get(position).getGroup().getUser();
            if (user != null) {
                String avatar_url = user.getAvatar_url();

                if (avatar_url != null) {
                    hold.sim_fre.setImageURI(Uri.parse(avatar_url));
                }

                String name = user.getName();
                if (name != null) {
                    hold.namtv.setText(name);

                }
            }
            //标题
            String content = list.get(position).getGroup().getContent();
            String text = list.get(position).getGroup().getText();
            if (text != "") {

                hold.nrtv.setText(text);


            }








        } else if (holder instanceof ViewHolder2) {
            ViewHolder2 hold = (ViewHolder2) holder;
            Mvpbean.DataBeanX.DataBean.GroupBean.Large_image large_image = list.get(position).getGroup().getLarge_image();

            if (large_image != null) {
                String url2 = large_image.getUrl_list().get(0).getUrl();
                if (url2 != null) {
                    hold.simzhu2.setImageURI(Uri.parse(url2));

                }
            }


            //标题
            GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(context.getResources());
            // 设置圆形图片
// 设置形状对象,形状为圆形
            RoundingParams params = RoundingParams.asCircle();
//创建设置参数,设置一个形状,把形状对象塞入
            GenericDraweeHierarchy roundness = builder.setRoundingParams(params).build();
//将参数对象设置给图片控件
            hold.sim_fre2.setHierarchy(roundness);

//头像
            Mvpbean.DataBeanX.DataBean.GroupBean.UserBean user = list.get(position).getGroup().getUser();
            if (user != null) {
                String avatar_url = user.getAvatar_url();

                if (avatar_url != null) {
                    hold.sim_fre2.setImageURI(Uri.parse(avatar_url));
                }

                String name = user.getName();
                if (name != null) {
                    hold.namtv2.setText(name);

                }
            }
            //标题
            String content = list.get(position).getGroup().getContent();
            String text = list.get(position).getGroup().getText();
            if (text != "") {

                hold.nrtv2.setText(text);


            }

            final GoodView goodView = new GoodView(context);

            hold.dz2btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goodView.setTextInfo("+1", Color.RED,20);
                   // goodView.setText("+1");
                    goodView.show(v);

                }
            });



        } else if (holder instanceof ViewHolder3) {
            ViewHolder3 holderr = (ViewHolder3) holder;


            String content1 = list.get(position).getGroup().getContent();

            if (content1 != null) {
                holderr.con2.setText(content1);

            }


            //标题
            GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(context.getResources());
            // 设置圆形图片
// 设置形状对象,形状为圆形
            RoundingParams params = RoundingParams.asCircle();
//创建设置参数,设置一个形状,把形状对象塞入
            GenericDraweeHierarchy roundness = builder.setRoundingParams(params).build();
//将参数对象设置给图片控件
            holderr.sim_fre2.setHierarchy(roundness);

//头像
            Mvpbean.DataBeanX.DataBean.GroupBean.UserBean user = list.get(position).getGroup().getUser();
            if (user != null) {
                String avatar_url = user.getAvatar_url();

                if (avatar_url != null) {
                    holderr.sim_fre2.setImageURI(Uri.parse(avatar_url));
                }

                String name = user.getName();
                if (name != null) {
                    holderr.namtv2.setText(name);

                }
            }
            //标题
            String content = list.get(position).getGroup().getContent();
            String text = list.get(position).getGroup().getText();
            if (text != "") {

                holderr.nrtv2.setText(text);


            }


            final GoodView goodView = new GoodView(context);

            holderr.dz2btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goodView.setTextInfo("+1", Color.RED,20);
                    goodView.show(v);

                }
            });

        }


    }





    @Override
    public int getItemViewType(int position) {

        if (list.get(position).getGroup().getMp4_url() != null) {
            return 1;

//list.get(position).getGroup().getLarge_image();
        } else if (list.get(position).getGroup().getLarge_image() != null) {
            return 2;
        } else {

            return 3;
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


class ViewHolder extends RecyclerView.ViewHolder {//视屏

    JCVideoPlayerStandard jcVideoPlayerStandard;
    SimpleDraweeView sim_fre;
    TextView namtv;
    TextView nrtv;

    public ViewHolder(View itemView) {
        super(itemView);


        jcVideoPlayerStandard = itemView.findViewById(R.id.videoplayer);
        sim_fre = itemView.findViewById(R.id.sim_fre);
        namtv = itemView.findViewById(R.id.nametv);
        nrtv = itemView.findViewById(R.id.neirong);


    }


}


class ViewHolder2 extends RecyclerView.ViewHolder {//图片

    SimpleDraweeView sim_fre2;
    TextView namtv2;
    TextView nrtv2;
    SimpleDraweeView simzhu2;
    ImageView dz1btn2;
    ImageView dz2btn2;
    ImageView pl2;
    ImageView zz2;
    //ImageView simzhu2;
    public ViewHolder2(View itemView) {
        super(itemView);

        sim_fre2 = itemView.findViewById(R.id.sim_fre);
        namtv2 = itemView.findViewById(R.id.nametv);
        nrtv2 = itemView.findViewById(R.id.neirong);
        simzhu2 = itemView.findViewById(R.id.simzhu);
        //simzhu2 = itemView.findViewById(R.id.simzhu);
        dz1btn2 = itemView.findViewById(R.id.dz1btn);
        dz2btn2 = itemView.findViewById(R.id.dz2btn);
        pl2 = itemView.findViewById(R.id.pl);
        zz2 = itemView.findViewById(R.id.zz);



    }


}


class ViewHolder3 extends RecyclerView.ViewHolder {//文本
    SimpleDraweeView sim_fre2;
    TextView namtv2;
    TextView nrtv2;
    TextView con2;
    ImageView dz1btn;
    ImageView dz2btn;
    ImageView pl;
    ImageView zz;

    public ViewHolder3(View itemView) {
        super(itemView);

        sim_fre2 = itemView.findViewById(R.id.sim_fre);
        namtv2 = itemView.findViewById(R.id.nametv);
        nrtv2 = itemView.findViewById(R.id.neirong);
        con2 = itemView.findViewById(R.id.simzhu);
        dz1btn = itemView.findViewById(R.id.dz1btn);
        dz2btn = itemView.findViewById(R.id.dz2btn);
        pl = itemView.findViewById(R.id.pl);
        zz = itemView.findViewById(R.id.zz);


    }


}

}









