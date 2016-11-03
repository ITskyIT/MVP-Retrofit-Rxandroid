package com.tian.mvpdemo.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.tian.mvpdemo.http.RetrofitHelper;

/**
 * activity 基类
 */
public abstract class BaseActivity<T extends BaseRx> extends AppCompatActivity implements BaseView{
    protected T mPresenter;
    protected RetrofitHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        helper=new RetrofitHelper();
        //创建 presenter

        mPresenter=createPresneter(helper);

        //关联view
        if (mPresenter != null)
            mPresenter.attachView(this);
    }

    protected abstract T createPresneter(RetrofitHelper helper);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除
        mPresenter.detachView();
    }

    @Override
    public void showLoadDialog() {
        Toast.makeText(this, "拼命加载中...", Toast.LENGTH_SHORT).show();
    }
}
