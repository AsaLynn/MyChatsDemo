package com.zxn.zchartslib.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;

import com.zxn.zchartslib.interfaces.ichart.IBarChart;
import com.zxn.zchartslib.interfaces.idata.IBarData;
import com.zxn.zchartslib.render.RoundBarChartRender;
import com.zxn.zchartslib.render.XAxisOffsetARender;
import com.zxn.zchartslib.render.YAxisOffsetARender;

/**
 * 圆头柱状图绘制类
 * Created by zxn on 2019/2/16.
 */
public class RoundBarChart extends BarLineCurveChart<IBarData> implements IBarChart {

    private RoundBarChartRender mBarChartRender;
    /**
     * 单个柱状图宽度
     */
    private float barWidth = 30;

    public RoundBarChart(Context context) {
        super(context);
    }

    public RoundBarChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundBarChart(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mXAxisData.setColor(Color.parseColor("#EEEEEE"));
        chartRenderList.clear();
        float offset;
        for (int i = 0; i < mDataList.size(); i++) {
            offset = mXAxisData.getInterval() * mXAxisData.getAxisScale() / 2 - barWidth * mDataList.size() / 2 + barWidth * i;
            mBarChartRender = new RoundBarChartRender(mDataList.get(i), mXAxisData, mYAxisData, offset, barWidth);
            chartRenderList.add(mBarChartRender);
        }
    }

    /**
     * 计算坐标轴刻度长度与View长度的比
     */
    @Override
    protected void axisScale() {
        mXAxisData.setAxisScale(mXAxisData.getAxisLength() / (mXAxisData.getMaximum() - mXAxisData.getMinimum() + mXAxisData.getInterval()));

        mYAxisData.setAxisScale(mYAxisData.getAxisLength() * 0.9f / (mYAxisData.getMaximum() - mYAxisData.getMinimum()));

        mXAxisData.setXAxisDividerHeight((int) (mYAxisData.getAxisLength() * 0.9));
        mXAxisRender = new XAxisOffsetARender(mXAxisData);

        mYAxisRender = new YAxisOffsetARender(mYAxisData, mXAxisData);
    }

    /**
     * 渲染X、Y轴
     *
     * @param canvas 画布
     */
    @Override
    protected void axisRender(Canvas canvas) {
        mXAxisRender.drawGraph(canvas);
        mYAxisRender.drawGraph(canvas);
    }

    /**
     * 设置柱状图宽度
     *
     * @param barWidth 宽度
     */
    @Override
    public void setBarWidth(float barWidth) {
        this.barWidth = barWidth;
    }

    @Override
    public void computeYAxis() {
        mComputeYAxis.computeYAxisMin(mDataList);
    }


}
