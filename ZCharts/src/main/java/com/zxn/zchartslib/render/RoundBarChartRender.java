package com.zxn.zchartslib.render;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;

import com.zxn.zchartslib.interfaces.idata.IBarData;
import com.zxn.zchartslib.interfaces.idata.IXAxisData;
import com.zxn.zchartslib.interfaces.idata.IYAxisData;

import java.text.NumberFormat;

/**
 * Created by zxn on 2019/2/16.
 */
public class RoundBarChartRender extends ChartRender {


    private IBarData barData;
    private Path barPath = new Path();
    private Paint barPaint = new Paint();
    private Paint textPaint = new Paint();

    private IXAxisData xAxisData;
    private IYAxisData yAxisData;
    private float offset;
    private PointF mPointF = new PointF();
    private Paint.FontMetrics fontMetrics;
    private float barWidth;
    private static final int LAYER_FLAGS = Canvas.ALL_SAVE_FLAG;

    public RoundBarChartRender(IBarData barData, IXAxisData xAxisData, IYAxisData yAxisData, float offset, float barWidth) {
        super();
        this.barData = barData;
        this.xAxisData = xAxisData;
        this.yAxisData = yAxisData;
        this.offset = offset;
        this.barWidth = barWidth;
        barPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        barPaint.setStrokeCap(Paint.Cap.ROUND);
        barPaint.setAntiAlias(true);
        textPaint.setAntiAlias(true);
        barPaint.setStrokeWidth(barData.getPaintWidth());
        //textPaint.setStrokeWidth(barData.getPaintWidth());
        textPaint.setTextSize(barData.getTextSize());
    }

    @Override
    public void drawGraph(Canvas canvas, float animatedValue) {
        float currentXAxis, currentYAxis;
        /**
         * 为添加更多点准备路径,可以更有效地分配其存储的路径
         */
        barPath.incReserve(barData.getValue().size());
        for (int j = 0; j < barData.getValue().size(); j++) {
            currentXAxis = (barData.getValue().get(j).x - xAxisData.getMinimum()) * xAxisData.getAxisScale() + offset;
            currentYAxis = -(barData.getValue().get(j).y - yAxisData.getMinimum()) * yAxisData.getAxisScale() * animatedValue;
            barPaint.setStrokeCap(Paint.Cap.ROUND);
            barPath.moveTo(currentXAxis + barWidth / 2, 0 - barWidth / 2);
            barPath.lineTo(currentXAxis + barWidth / 2, currentYAxis);
        }
        /**
         * 柱状图图层为0x80半透明状态
         */
        canvas.saveLayerAlpha(-canvas.getWidth() + xAxisData.getAxisLength(), -yAxisData.getAxisLength(),
                xAxisData.getAxisLength(), canvas.getHeight() - yAxisData.getAxisLength(), 0x80, Canvas.ALL_SAVE_FLAG);
        barPaint.setColor(barData.getColor());
        barPaint.setStrokeWidth(barWidth);
        canvas.drawPath(barPath, barPaint);
        barPath.reset();
        for (int j = 0; j < barData.getValue().size(); j++) {
            currentXAxis = (barData.getValue().get(j).x - xAxisData.getMinimum()) * xAxisData.getAxisScale() + offset;
            currentYAxis = -(barData.getValue().get(j).y - yAxisData.getMinimum()) * yAxisData.getAxisScale() * animatedValue;
            barPaint.setStrokeCap(Paint.Cap.BUTT);
            barPath.moveTo(currentXAxis + barWidth / 2, 0);
            barPath.lineTo(currentXAxis + barWidth / 2, currentYAxis);


            fontMetrics = textPaint.getFontMetrics();
            mPointF.x = currentXAxis + barWidth / 2;
            mPointF.y = currentYAxis + (fontMetrics.top - fontMetrics.bottom) - barWidth/2;
            NumberFormat numberFormatY = NumberFormat.getNumberInstance();
            numberFormatY.setMaximumFractionDigits(yAxisData.getDecimalPlaces());

            textPaint.setColor(Color.parseColor("#4E4E4E"));
            if (barData.getIsTextSize())
                textCenter(new String[]{numberFormatY.format(barData.getValue().get(j).y)}, textPaint, canvas, mPointF, Paint.Align.CENTER);

        }
        canvas.drawPath(barPath, barPaint);
        canvas.restore();
        barPath.reset();
    }


}
