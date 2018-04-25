package com.example.administrator.waterenvironment.person;

import android.app.AlertDialog;
import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.waterenvironment.R;
import com.example.administrator.waterenvironment.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：MTT
 * 创建日期：2018/4/20
 * 描述：修改密码
 */
public class ChangePasswordActivity extends BaseActivity {
    @BindView(R.id.title_left)
    ImageView title_left;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.title_right)
    TextView title_right;
    @BindView(R.id.tv_sure)
    TextView tv_sure;
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        ButterKnife.bind(this);
        title.setText("修改密码");
        title_right.setText("取消");
        tv_sure.setText("确定");
    }

    @OnClick({R.id.tv_sure, R.id.title_left, R.id.title_right})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_sure:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                View v = LayoutInflater.from(this).inflate(R.layout.item_dialog, null);
                TextView tv_sure = v.findViewById(R.id.tv_sure);
                tv_sure.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(ChangePasswordActivity.this, "弹窗确定。然后不知道要跳哪儿",
                                Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                    }
                });
                builder.setView(v);
                alertDialog = builder.show();
                break;
            case R.id.title_left:
                finish();
                break;
            case R.id.title_right:
                Toast.makeText(this, "这是个多余的按钮，然而并没有什么卵用", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
