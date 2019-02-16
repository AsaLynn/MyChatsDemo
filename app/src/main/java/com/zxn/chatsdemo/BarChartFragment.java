package com.zxn.chatsdemo;

import android.graphics.PointF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zxn.zchartslib.chart.BarChart;
import com.zxn.zchartslib.data.BarData;
import com.zxn.zchartslib.interfaces.idata.IBarData;

import java.util.ArrayList;

/**
 * Created by Idtk on 2016/6/26.
 * Blog : http://www.idtkm.com
 * GitHub : https://github.com/Idtk
 * 描述 : 柱状图
 */
public class BarChartFragment extends BaseFragment{

    private ArrayList<IBarData> mDataList = new ArrayList<>();
    private BarData mBarData = new BarData();
    private ArrayList<PointF> mPointArrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_barchart,container,false);
        BarChart barChart = (BarChart)view.findViewById(R.id.barChart);
        initData();
//        barChart.setData(mBarData);
        barChart.setDataList(mDataList);
        //barChart.setXAxisUnit("X单位");
        //barChart.setYAxisUnit("Y单位");
        return view;
    }

    private void initData() {
        for (int i = 0; i < 7; i++) {
            mPointArrayList.add(new PointF(points[i][0], points[i][1]));
        }
        mBarData.setValue(mPointArrayList);
        //mBarData.setColor(Color.CYAN);
//        mBarData.setColor(getResources().getColor(R.color.c_46e494));
        mBarData.setColor(getResources().getColor(R.color.c_40e1a6));
        //mBarData.setPaintWidth(getResources().getDimension(R.dimen.dp_9));
        mBarData.setPaintWidth(9);
        mBarData.setTextSize(pxTodp(11));
//        mBarData.setTextSize(11);

        mDataList.add(mBarData);
    }
}
