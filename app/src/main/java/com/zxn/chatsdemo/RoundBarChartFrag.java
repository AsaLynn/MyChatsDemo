package com.zxn.chatsdemo;


import android.graphics.PointF;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.zxn.zchartslib.chart.BarChart;
import com.zxn.zchartslib.chart.RoundBarChart;
import com.zxn.zchartslib.data.BarData;
import com.zxn.zchartslib.interfaces.idata.IBarData;

import java.util.ArrayList;


/**
 * 圆角
 * Created by zxn on 2019-2-16 15:28:40.
 */
public class RoundBarChartFrag extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";


    private String mParam1;


    public RoundBarChartFrag() {
    }

    public static RoundBarChartFrag newInstance(String param1) {
        RoundBarChartFrag fragment = new RoundBarChartFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    public static RoundBarChartFrag newInstance() {
        RoundBarChartFrag fragment = new RoundBarChartFrag();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }


    private ArrayList<IBarData> mDataList = new ArrayList<>();
    private BarData mBarData = new BarData();
    private ArrayList<PointF> mPointArrayList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_round_bar_chart, container, false);
        LinearLayout root = view.findViewById(R.id.ll_root);
        RoundBarChart barChart = new RoundBarChart(getActivity());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        root.addView(barChart, params);
        //RoundBarChart barChart = (RoundBarChart)view.findViewById(R.id.barChart);
        initData();
        barChart.setDataList(mDataList);
        return view;
    }

    private void initData() {
        for (int i = 0; i < 7; i++) {
            mPointArrayList.add(new PointF(points[i][0], points[i][1]));
        }
        mBarData.setValue(mPointArrayList);
//        mBarData.setColor(getResources().getColor(R.color.c_46e494));
        mBarData.setColor(getResources().getColor(R.color.c_40e1a6));
        mBarData.setPaintWidth(9);
        mBarData.setTextSize(pxTodp(11));
        mDataList.add(mBarData);
    }

}
