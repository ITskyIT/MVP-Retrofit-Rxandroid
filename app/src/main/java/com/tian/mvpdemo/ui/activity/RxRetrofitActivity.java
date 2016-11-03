package com.tian.mvpdemo.ui.activity;

import android.os.Bundle;
import android.widget.ListView;

import com.tian.mvpdemo.R;
import com.tian.mvpdemo.adapter.FuLiGirlAdapter;
import com.tian.mvpdemo.base.BaseActivity;
import com.tian.mvpdemo.bean.FuLiGirl;
import com.tian.mvpdemo.http.RetrofitHelper;
import com.tian.mvpdemo.presenter.FuliGirlPresenterImpl;
import com.tian.mvpdemo.view.IFuLiGirlView;

public class RxRetrofitActivity extends BaseActivity<FuliGirlPresenterImpl> implements IFuLiGirlView{
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_retrofit);
        listView= (ListView) findViewById(R.id.listView);
        mPresenter.getData();
    }

    @Override
    protected FuliGirlPresenterImpl createPresneter(RetrofitHelper helper) {
        return new FuliGirlPresenterImpl(helper);
    }

    @Override
    public void showFuliGirl(FuLiGirl data) {
        listView.setAdapter(new FuLiGirlAdapter(this,data.getResults()));
    }

    @Override
    public void showTest(String msg) {

    }
}
