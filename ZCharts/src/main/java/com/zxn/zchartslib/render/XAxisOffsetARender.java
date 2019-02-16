package com.zxn.zchartslib.render;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;

import com.zxn.zchartslib.interfaces.idata.IXAxisData;

import java.text.NumberFormat;

/**
 * x坐标轴
 * Created by zxn on 2019/2/16.
 */
public class XAxisOffsetARender extends AxisRender {


    private Paint mPaint = new Paint();
    private IXAxisData xAxisData;
    private NumberFormat numberFormat;
    private PointF mPoint = new PointF();

    public XAxisOffsetARender(IXAxisData xAxisData) {
        super();
        this.xAxisData = xAxisData;
        mPaint.setColor(xAxisData.getColor());
        mPaint.setTextSize(xAxisData.getTextSize());
        mPaint.setStrokeWidth(xAxisData.getPaintWidth());
        //设置小数点位数
        numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(xAxisData.getDecimalPlaces());

    }

    @Override
    public void drawGraph(Canvas canvas) {
        //canvas.drawLine(0,0,xAxisData.getAxisLength(),0,mPaint);
        for (int i = 0; (xAxisData.getInterval() * i + xAxisData.getMinimum()) <= xAxisData.getMaximum(); i++) {

            //drawLine(float startX, float startY, float stopX, float stopY,Paint paint)
            if (i == 0) continue;
            canvas.drawLine((float) (xAxisData.getInterval() * (i) * xAxisData.getAxisScale()),
                    0,
                    (float) (xAxisData.getInterval() * (i) * xAxisData.getAxisScale()),
                    xAxisData.getXAxisDividerHeight(), mPaint);
            canvas.save();
            canvas.scale(1, -1);
            /**
             * 偏移距离
             */
            canvas.translate(xAxisData.getInterval() * xAxisData.getAxisScale() / 2, 0);
//            /**
//             * 坐标数值
//             */
            /*float TextPathX = (float) (xAxisData.getInterval()*i*xAxisData.getAxisScale());
            float TextPathY = (mPaint.descent()+mPaint.ascent())-xAxisData.getAxisLength()/100;
            mPoint.x = TextPathX;
            mPoint.y = -TextPathY;
            textCenter(new String[]{numberFormat.format(xAxisData.getInterval()*i+xAxisData.getMinimum())},
                    mPaint,canvas, mPoint, Paint.Align.CENTER);*/
            canvas.restore();
        }

//        /**
//         * 箭头
//         */
//        canvas.drawLine(xAxisData.getAxisLength(),0,xAxisData.getAxisLength()*0.99f,xAxisData.getAxisLength()*0.01f,mPaint);
//        canvas.drawLine(xAxisData.getAxisLength(),0,xAxisData.getAxisLength()*0.99f,-xAxisData.getAxisLength()*0.01f,mPaint);
//        canvas.save();
//        canvas.scale(1,-1);
//        canvas.drawText(xAxisData.getUnit(),xAxisData.getAxisLength(),(mPaint.descent()+mPaint.ascent())-xAxisData.getAxisLength()/100,mPaint);
//        canvas.restore();
    }


}
