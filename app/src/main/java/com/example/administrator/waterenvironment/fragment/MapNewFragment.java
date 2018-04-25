package com.example.administrator.waterenvironment.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.waterenvironment.R;

public class MapNewFragment extends Fragment {


    public MapNewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map_new, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

    }


}
