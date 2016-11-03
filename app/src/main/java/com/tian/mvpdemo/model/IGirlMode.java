package com.tian.mvpdemo.model;

import com.tian.mvpdemo.bean.GirlBean;

import java.util.List;

/**
 * GIrl mode接口
 */

public interface IGirlMode {


    /**
     * 加载数据
     */
    void LoadGirl(OnLoadingListener onLoadingListener);

    interface OnLoadingListener{
        void onLoadComplete(List<GirlBean> girls);
    }
}
