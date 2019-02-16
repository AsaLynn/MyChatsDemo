package com.zxn.zchartslib.interfaces.idata;

/**
 * X轴数据类接口
 * Created by zxn on 2019/2/15.
 */
public interface IXAxisData extends IAxisData {

    /**
     * 设置x轴分割线高度
     */
    void setXAxisDividerHeight(int height);

    /**
     * 获取x轴分割线高度
     */
    int getXAxisDividerHeight();
}
