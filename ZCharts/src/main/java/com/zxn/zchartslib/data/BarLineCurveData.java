package com.zxn.zchartslib.data;

import android.graphics.PointF;

import com.zxn.zchartslib.interfaces.idata.IBarLineCurveData;

import java.util.ArrayList;

/**
 * 柱状图、折线图、曲线图数据基类
 * Created by zxn on 2019/2/16.
 */
public class BarLineCurveData extends ChartData implements IBarLineCurveData {
    protected ArrayList<PointF> value;

    public void setValue(ArrayList<PointF> value) {
        this.value = value;
    }

    public ArrayList<PointF> getValue() {
        return value;
    }

}