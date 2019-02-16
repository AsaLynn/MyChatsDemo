package com.zxn.zchartslib.interfaces.idata;

/**
 * Created by zxn on 2019/2/15.
 */
public interface IChartData extends IBaseData{

    /**
     * 设置图表名称
     * @param name 图表名
     */
    void setName(String name);

    /**
     * 获取图表名称
     * @return 图表名
     */
    String getName();
}
