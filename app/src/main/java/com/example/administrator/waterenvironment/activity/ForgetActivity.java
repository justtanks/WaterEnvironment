package com.example.administrator.waterenvironment.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.waterenvironment.R;
import com.example.administrator.waterenvironment.base.BaseActivity;
import com.example.administrator.waterenvironment.view.CodeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgetActivity extends BaseActivity {
    private CodeUtils codeUtils;
    @BindView(R.id.img_open)
    ImageView img_open;
    @BindView(R.id.title_left)
    ImageView title_left;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.title_right)
    TextView title_right;
    @BindView(R.id.tv_getCode)
    TextView tv_getCode;
    @BindView(R.id.ed_forget_number)
    EditText ed_forget_number;
    @BindView(R.id.ed_forget_code)
    EditText ed_forget_code;
    @BindView(R.id.ed_forget_user)
    EditText ed_forget_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        ButterKnife.bind(this);
        title_left.setVisibility(View.INVISIBLE);
        title.setText("忘记密码");
        changeCode();
    }

    @OnClick({R.id.title_right, R.id.tv_getCode, R.id.tv_sure, R.id.img_open})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_right:
                finish();
                break;
            case R.id.tv_getCode:
                Timeout();
                break;
            case R.id.tv_sure:
                if (ed_forget_number.getText().toString().equals("") && !ed_forget_code.getText().toString().equals("") && ed_forget_user.getText().toString().equals("")) {
                    Toast.makeText(this, "请填写完整的信息", Toast.LENGTH_SHORT).show();
                } else if (isPhone(ed_forget_number.getText().toString()) == false) {
                    Toast.makeText(this, "请输入完正确的手机号", Toast.LENGTH_SHORT).show();
                } else {
                    Intent in = new Intent(this, NewPaawordActivity.class);
                    startActivity(in);
                    finish();
                }
                break;
            case R.id.img_open:
                changeCode();
                break;
        }

    }

    public void Timeout() {
        CountDownTimer timer = new CountDownTimer(60 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // TODO Auto-generated method stub
                tv_getCode.setText("还剩" + millisUntilFinished / 1000 + "秒");
            }

            @Override
            public void onFinish() {
                tv_getCode.setText("获取验证码");
            }
        }.start();
    }

    public void changeCode() {
        codeUtils = CodeUtils.getInstance();
        Bitmap bitmap = codeUtils.createBitmap();
        img_open.setImageBitmap(bitmap);
    }


}
