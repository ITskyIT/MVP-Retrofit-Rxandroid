package com.tian.mvpdemo.model.impl;

import com.tian.mvpdemo.bean.GirlBean;
import com.tian.mvpdemo.model.IGirlMode;

import java.util.ArrayList;
import java.util.List;

/**
 * 业务逻辑
 */
public class GirlModeImpl implements IGirlMode {


    @Override
    public void LoadGirl(OnLoadingListener onLoadingListener) {
        /**
         * 模拟从网络下载
         */
        List<GirlBean> data=new ArrayList<>();
        data.add(0,new GirlBean("http://ww2.sinaimg.cn/large/610dc034jw1f9b46kpoeoj20ku0kuwhc.jpg","这是描述1","一颗星"));
        data.add(1,new GirlBean("http://ww2.sinaimg.cn/large/610dc034jw1f978bh1cerj20u00u0767.jpg","这是描述2","二颗星"));
        data.add(2,new GirlBean("http://ww4.sinaimg.cn/large/610dc034gw1f96kp6faayj20u00jywg9.jpg","这是描述3","三颗星"));
        data.add(3,new GirlBean("http://ww4.sinaimg.cn/large/610dc034jw1f95hzq3p4rj20u011htbm.jpg","这是描述4","四颗星"));
        data.add(4,new GirlBean("http://ww4.sinaimg.cn/large/610dc034jw1f9469eoojtj20u011hdjy.jpg","这是描述5","五颗星"));
        onLoadingListener.onLoadComplete(data);
    }
}
