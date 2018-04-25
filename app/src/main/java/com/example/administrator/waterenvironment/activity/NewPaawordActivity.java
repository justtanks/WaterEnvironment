package com.example.administrator.waterenvironment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.waterenvironment.MainActivity;
import com.example.administrator.waterenvironment.R;
import com.example.administrator.waterenvironment.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewPaawordActivity extends BaseActivity {
    @BindView(R.id.title_left)
    ImageView title_left;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.ed_newpassword)
    EditText ed_newpassword;
    @BindView(R.id.ed_newpassword2)
    EditText ed_newpassword2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_paaword);
        ButterKnife.bind(this);
        title_left.setVisibility(View.INVISIBLE);
        title.setText("忘记密码");
    }

    @OnClick({R.id.title_right, R.id.tv_sure})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_right:
                finish();
                break;
            case R.id.tv_sure:
                if (ed_newpassword.getText().toString().equals("") && ed_newpassword2.getText().toString().equals("")) {
                    Toast.makeText(this, "请填写完整密码", Toast.LENGTH_SHORT).show();
                } else if (!ed_newpassword.getText().toString().equals(ed_newpassword2.getText().toString())) {
                    Toast.makeText(this, "两次新密码请输入一致", Toast.LENGTH_SHORT).show();
                } else {
                    //返回到登录页面
                    finish();
                }
                break;
        }

    }

}
