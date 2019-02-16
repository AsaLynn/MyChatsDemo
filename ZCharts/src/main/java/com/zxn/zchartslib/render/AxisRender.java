package com.zxn.zchartslib.render;

import android.graphics.Canvas;

/**
 * 坐标轴渲染基类
 * Created by zxn on 2019/2/15.
 */
public abstract class AxisRender extends Render{
    public AxisRender() {
        super();
    }

    /**
     * 坐标轴渲染方法
     *
     * @param canvas 画布
     */
    public abstract void drawGraph(Canvas canvas);
}
