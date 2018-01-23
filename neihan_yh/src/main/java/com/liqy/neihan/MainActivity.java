package com.liqy.neihan;


import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.hjm.bottomtabbar.BottomTabBar;
import com.liqy.neihan.View.IView;
import com.liqy.neihan.bean.Bean;
import com.liqy.neihan.fragment.AuditFragment;
import com.liqy.neihan.fragment.DiscoverFragment;
import com.liqy.neihan.fragment.HomePageFragment;
import com.liqy.neihan.fragment.NewsFragment;
import com.liqy.neihan.presenter.Presenter;

import java.util.HashMap;
import java.util.Map;

/**
 * 内涵段子首页
 * 接口
 */
public class MainActivity extends AppCompatActivity {


    private BottomTabBar bottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      /*  Window window = getWindow();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }*/
        setContentView(R.layout.activity_main);
        initView();


        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(50, 50)
                .setFontSize(10)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.RED, Color.BLACK)
                .addTabItem("首页", R.drawable.sy, HomePageFragment.class)
                .addTabItem("发现", R.drawable.fx, DiscoverFragment.class)
                .addTabItem("审核", R.drawable.sh, AuditFragment.class)
                .addTabItem("消息", R.drawable.xx, NewsFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });

    }

    private void initView() {
        bottomTabBar = (BottomTabBar) findViewById(R.id.bottomTabBar);
    }
}