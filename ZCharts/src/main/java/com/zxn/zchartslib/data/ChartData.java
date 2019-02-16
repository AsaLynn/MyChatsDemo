package com.zxn.zchartslib.data;

import com.zxn.zchartslib.interfaces.idata.IChartData;

/**
 * 图表数据基类
 * Created by zxn on 2019/2/16.
 */
public class ChartData extends BaseData implements IChartData {
    protected String name="";

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
