package com.example.administrator.waterenvironment.person;

import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.waterenvironment.R;
import com.example.administrator.waterenvironment.base.BaseActivity;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：MTT
 * 创建日期：2018/4/20
 * 描述：修改头像
 */
public class ChangeUserImgAcivity extends BaseActivity {
    @BindView(R.id.title_left)
    ImageView title_left;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.title_right)
    TextView title_right;
    private int mCurrentDialogStyle = com.qmuiteam.qmui.R.style.QMUI_Dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_user_img_acivity);
        ButterKnife.bind(this);
        title.setText("我的头像");
        title_right.setText("修改");
    }

    @OnClick({R.id.title_left, R.id.title_right})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_left:
                finish();
                break;
            case R.id.title_right:
                //弹窗，然后要选择
                showSingleChoiceDialog();
                break;
        }

    }

    private void showSingleChoiceDialog() {
        final String[] items = new String[]{"相机", "相册"};
        new QMUIDialog.CheckableDialogBuilder(this)
                .addItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == 0) {
                            Toast.makeText(ChangeUserImgAcivity.this, "相机", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(ChangeUserImgAcivity.this, "相册", Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    }
                })
                .create(mCurrentDialogStyle).show();
    }

}
