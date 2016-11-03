package com.tian.mvpdemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.tian.mvpdemo.R;
import com.tian.mvpdemo.adapter.GirlAdapter;
import com.tian.mvpdemo.base.BaseActivity;
import com.tian.mvpdemo.bean.GirlBean;
import com.tian.mvpdemo.http.RetrofitHelper;
import com.tian.mvpdemo.presenter.GirlPresenterImpl;
import com.tian.mvpdemo.view.IGirlView;

import java.util.List;

public class MainActivity extends BaseActivity<GirlPresenterImpl> implements IGirlView{
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.list);
        mPresenter.feat();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                startActivity(new Intent(MainActivity.this, RxRetrofitActivity.class));
            }
        });
    }

    @Override
    protected GirlPresenterImpl createPresneter(RetrofitHelper helper) {
        return new GirlPresenterImpl();
    }

    @Override
    public void showLoadDialog() {
        Toast.makeText(MainActivity.this, "拼命加载中...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showGirl(List<GirlBean> girls) {
        listView.setAdapter(new GirlAdapter(this,girls));
    }

    @Override
    public void showTest(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}
