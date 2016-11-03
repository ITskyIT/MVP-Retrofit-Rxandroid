package com.tian.mvpdemo.view;

import com.tian.mvpdemo.base.BaseView;
import com.tian.mvpdemo.bean.GirlBean;

import java.util.List;

/**
 * Girl view
 */
public interface IGirlView extends BaseView{

    void showGirl(List<GirlBean> girls);
}
