package com.example.administrator.waterenvironment.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.waterenvironment.R;
/**
 *
 * 作者：MTT
 * 创建日期：2018/4/25
 * 描述：主页额站点
 *
 */
public class MaintenanceFragment extends Fragment {

    public MaintenanceFragment() {

    }

    public static MaintenanceFragment newInstance(String param1, String param2) {
        MaintenanceFragment fragment = new MaintenanceFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_maintenance, container, false);
    }


}
