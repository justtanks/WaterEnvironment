package com.example.administrator.waterenvironment.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.TextureMapView;
import com.example.administrator.waterenvironment.R;
/**
 *
 * 作者：MTT
 * 创建日期：2018/4/25
 * 描述：主页的地图
 *
 */
public class MapNewFragment extends Fragment {
    private TextureMapView mMapView;
    private BaiduMap mBaiduMap;
    TextView tv_station;


    public MapNewFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SDKInitializer.initialize(getActivity().getApplicationContext());

        View v = inflater.inflate(R.layout.fragment_map_new, container, false);
        mMapView = (TextureMapView) v.findViewById(R.id.mTexturemap);
        tv_station = (TextView) v.findViewById(R.id.tv_station);
        tv_station.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "站点列表", Toast.LENGTH_SHORT).show();
            }
        });
        mBaiduMap = mMapView.getMap();
        return v;
    }


    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    public void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }

}
