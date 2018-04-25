package com.example.administrator.waterenvironment.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.waterenvironment.MainActivity;
import com.example.administrator.waterenvironment.R;
import com.example.administrator.waterenvironment.base.BaseActivity;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：MTT
 * 创建日期：2018/4/18
 * 描述：登陆页
 */
public class LoginActivity extends BaseActivity {
    @BindView(R.id.tv_login)
    TextView tv_login;
    @BindView(R.id.img_open)
    ImageView img_open;
    @BindView(R.id.ed_login_password)
    EditText ed_login_password;
    @BindView(R.id.ed_login_phone)
    EditText ed_login_phone;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QMUIStatusBarHelper.translucent(this);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_login, R.id.img_open, R.id.forget_tv})
    public void onclick(View v) {
        switch (v.getId()) {
            case R.id.tv_login:
                if (isPhone(ed_login_phone.getText().toString()) == false) {
                    Toast.makeText(this, "手机号不符合格式请重新输入", Toast.LENGTH_SHORT).show();
                } else if (ed_login_phone.getText().toString().equals("") && ed_login_password.getText().toString().equals("")) {
                    Toast.makeText(this, "请填写完整的信息", Toast.LENGTH_SHORT).show();
                } else {
                    intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

                break;
            case R.id.img_open:
                if (img_open.getDrawable().getCurrent().getConstantState().equals(getResources().getDrawable(R.mipmap.login_close).getConstantState())) {
                    img_open.setImageResource(R.mipmap.login_open);
                    ed_login_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    img_open.setImageResource(R.mipmap.login_close);
                    ed_login_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                break;
            case R.id.forget_tv:
                intent = new Intent(this, ForgetActivity.class);
                startActivity(intent);
                break;
        }


    }


}
