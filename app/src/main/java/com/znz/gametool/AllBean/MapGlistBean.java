package com.znz.gametool.AllBean;

import android.graphics.drawable.Drawable;

public class MapGlistBean {

    //组数据
    String BmapName;
    public MapGlistBean(String BmapName)
    {
        this.BmapName = BmapName;
    }

    public String getBmapName() {
        return BmapName;
    }

    public void setBmapName(String bmapName) {
        BmapName = bmapName;
    }
}
