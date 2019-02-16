package com.zxn.zchartslib.data;

import com.zxn.zchartslib.interfaces.idata.IXAxisData;

/**
 * X轴数据类
 * Created by zxn on 2019/2/15.
 */
public class XAxisData extends AxisData implements IXAxisData {

    private int xDividerHeight;


    /**
     * 设置x轴分割线高度
     *
     * @param height
     */
    @Override
    public void setXAxisDividerHeight(int height) {
        xDividerHeight = height;
    }

    /**
     * 获取x轴分割线高度
     */
    @Override
    public int getXAxisDividerHeight() {
        return xDividerHeight;
    }
}
