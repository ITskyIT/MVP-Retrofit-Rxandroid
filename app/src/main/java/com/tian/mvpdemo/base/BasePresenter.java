package com.tian.mvpdemo.base;

/**
 * Created by jiujiu on 2016/11/1.
 */
public interface BasePresenter<T extends BaseView> {

    void attachView(T view);
    void detachView();
}
