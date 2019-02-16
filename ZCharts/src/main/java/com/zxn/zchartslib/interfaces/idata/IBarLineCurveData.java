package com.zxn.zchartslib.interfaces.idata;

import android.graphics.PointF;

import java.util.ArrayList;

/**
 * 柱状图、折线图、曲线图数据类接口
 * Created by zxn on 2019/2/15.
 */
public interface IBarLineCurveData extends IChartData {
    /**
     * 设置图表数据
     * @param value 图表数据
     */
    void setValue(ArrayList<PointF> value);

    /**
     * 获取图表数据
     * @return 图表数据
     */
    ArrayList<PointF> getValue();
}
