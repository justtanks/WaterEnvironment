package com.example.administrator.waterenvironment.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

import com.example.administrator.waterenvironment.MainActivity;
import com.example.administrator.waterenvironment.R;
import com.example.administrator.waterenvironment.base.BaseActivity;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 作者：MTT
 * 创建日期：2018/4/18
 * 描述：欢迎页
 */
public class WelActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QMUIStatusBarHelper.translucent(this);
        setContentView(R.layout.activity_wel);
        toM();
    }

    //时间
    private void toM() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(WelActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        };
        timer.schedule(task, 1500 * 1);

    }

}

