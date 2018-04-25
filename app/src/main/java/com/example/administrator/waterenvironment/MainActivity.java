package com.example.administrator.waterenvironment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.waterenvironment.base.BaseActivity;
import com.example.administrator.waterenvironment.fragment.MaintenanceFragment;
import com.example.administrator.waterenvironment.fragment.ManageFragment;
import com.example.administrator.waterenvironment.fragment.MapNewFragment;
import com.example.administrator.waterenvironment.fragment.StatisticsFragment;
import com.example.administrator.waterenvironment.fragment.VideoFragment;
import com.example.administrator.waterenvironment.person.*;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：MTT
 * 创建日期：2018/4/18
 * 描述：主页
 */
public class MainActivity extends BaseActivity {

    private DrawerLayout mDrawerLayout;
    TextView changeImg;
    TextView changePassword;
    TextView set;
    TextView out_login;
    Intent intent;
    NavigationView navigationView;
    LinearLayout headerLayout;

    @BindView(R.id.content_layout)
    FrameLayout content_layout;
    @BindView(R.id.map_home)//地图
            LinearLayout map_home;
    @BindView(R.id.img_map)
    ImageView img_map;
    @BindView(R.id.tv_map)
    TextView tv_map;
    @BindView(R.id.home_statistics)//统计
            LinearLayout home_statistics;
    @BindView(R.id.img_statistics)
    ImageView img_statistics;
    @BindView(R.id.tv_statistics)
    TextView tv_statistics;
    @BindView(R.id.home_manage)//设备
            LinearLayout home_manage;
    @BindView(R.id.img_manage)
    ImageView img_manage;
    @BindView(R.id.tv_manage)
    TextView tv_manage;
    @BindView(R.id.home_maintenance)//站点
            LinearLayout home_maintenance;
    @BindView(R.id.img_maintenance)
    ImageView img_maintenance;
    @BindView(R.id.tv_maintenance)
    TextView tv_maintenance;
    @BindView(R.id.home_video)//视频
            LinearLayout home_video;
    @BindView(R.id.img_video)
    ImageView img_video;
    @BindView(R.id.tv_video)
    TextView tv_video;

    MapNewFragment mapFragment;
    MaintenanceFragment maintenanceFragment;
    ManageFragment manageFragment;
    StatisticsFragment statisticsFragment;
    VideoFragment videoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QMUIStatusBarHelper.translucent(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //下面的代码主要通过actionbardrawertoggle将toolbar与drawablelayout关联起来
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, null, R.string.home_map, R.string.home_video);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        leftOnClick();
        resView(1);

    }

    //侧滑点击事件以及加载布局
    private void leftOnClick() {
        navigationView = (NavigationView) findViewById(R.id.navigationview);
        headerLayout = (LinearLayout) navigationView.inflateHeaderView(R.layout.person);
        set = headerLayout.findViewById(R.id.tv_set);
        changeImg = headerLayout.findViewById(R.id.tv_changeimg);
        changePassword = headerLayout.findViewById(R.id.tv_changepassword);
        out_login = headerLayout.findViewById(R.id.tv_out_login);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, SetActivity.class);
                startActivity(intent);
            }
        });
        changeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, ChangeUserImgAcivity.class);
                startActivity(intent);
            }
        });
        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, ChangePasswordActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @OnClick({R.id.map_home, R.id.home_statistics, R.id.home_manage, R.id.home_maintenance, R.id.home_video})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.map_home:
                resView(1);
                break;
            case R.id.home_statistics://img_statistics
                resView(4);
                break;
            case R.id.home_manage:
                resView(3);
                break;
            case R.id.home_maintenance:
                resView(2);
                break;
            case R.id.home_video:
                resView(5);
                break;
        }
    }

    public void setTextView(TextView tv1, TextView tv2, TextView tv3, TextView tv4, TextView tv5) {
        tv1.setTextColor(getResources().getColor(R.color.text_main));
        tv2.setTextColor(getResources().getColor(R.color.home_text));
        tv3.setTextColor(getResources().getColor(R.color.home_text));
        tv4.setTextColor(getResources().getColor(R.color.home_text));
        tv5.setTextColor(getResources().getColor(R.color.home_text));
    }

    private void resView(int i) {
        try {
            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            mapFragment = new MapNewFragment();
            maintenanceFragment = new MaintenanceFragment();
            manageFragment = new ManageFragment();
            statisticsFragment = new StatisticsFragment();
            videoFragment = new VideoFragment();

            switch (i) {
                case 1:
                    transaction.replace(R.id.content_layout, mapFragment);
                    setTextView(tv_map, tv_maintenance, tv_manage, tv_statistics, tv_video);
                    img_map.setImageResource(R.mipmap.map_home_choice);
                    img_maintenance.setImageResource(R.mipmap.home_station);
                    img_manage.setImageResource(R.mipmap.home_shebei);
                    img_statistics.setImageResource(R.mipmap.home_tongji);
                    img_video.setImageResource(R.mipmap.home_vedio);
                    break;
                case 2:
                    transaction.replace(R.id.content_layout, maintenanceFragment);
                    setTextView(tv_maintenance, tv_manage, tv_statistics, tv_map, tv_video);
                    img_map.setImageResource(R.mipmap.home_map_unchoice);
                    img_maintenance.setImageResource(R.mipmap.home_satation_choice);
                    img_manage.setImageResource(R.mipmap.home_shebei);
                    img_statistics.setImageResource(R.mipmap.home_tongji);
                    img_video.setImageResource(R.mipmap.home_vedio);
                    break;
                case 3:
                    transaction.replace(R.id.content_layout, manageFragment);
                    setTextView(tv_manage, tv_statistics, tv_maintenance, tv_map, tv_video);
                    img_map.setImageResource(R.mipmap.home_map_unchoice);
                    img_statistics.setImageResource(R.mipmap.home_tongji);
                    img_manage.setImageResource(R.mipmap.home_manange_choice);
                    img_maintenance.setImageResource(R.mipmap.home_station);
                    img_video.setImageResource(R.mipmap.home_vedio);
                    break;
                case 4:
                    transaction.replace(R.id.content_layout, statisticsFragment);
                    setTextView(tv_statistics, tv_maintenance, tv_manage, tv_map, tv_video);
                    img_map.setImageResource(R.mipmap.home_map_unchoice);
                    img_maintenance.setImageResource(R.mipmap.home_station);
                    img_manage.setImageResource(R.mipmap.home_shebei);
                    img_statistics.setImageResource(R.mipmap.home_tongji_choice);
                    img_video.setImageResource(R.mipmap.home_vedio);
                    break;
                case 5:
                    transaction.replace(R.id.content_layout, videoFragment);
                    setTextView(tv_video, tv_maintenance, tv_manage, tv_statistics, tv_map);
                    img_manage.setImageResource(R.mipmap.home_map_unchoice);
                    img_maintenance.setImageResource(R.mipmap.home_tongji);
                    img_manage.setImageResource(R.mipmap.home_shebei);
                    img_maintenance.setImageResource(R.mipmap.home_station);
                    img_video.setImageResource(R.mipmap.home_video_choice);
                    break;
            }
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
