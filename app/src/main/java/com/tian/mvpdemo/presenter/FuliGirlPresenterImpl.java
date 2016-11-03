package com.tian.mvpdemo.presenter;

import com.tian.mvpdemo.base.BaseRx;
import com.tian.mvpdemo.bean.FuLiGirl;
import com.tian.mvpdemo.http.RetrofitHelper;
import com.tian.mvpdemo.rx.RxUtil;
import com.tian.mvpdemo.view.IFuLiGirlView;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by jiujiu on 2016/11/2.
 */
public class FuliGirlPresenterImpl extends BaseRx<IFuLiGirlView>{
    private RetrofitHelper mRetrofitHelper;

    public FuliGirlPresenterImpl(RetrofitHelper mRetrofitHelper) {
        this.mRetrofitHelper = mRetrofitHelper;
    }
    public void getData() {
        mView.showLoadDialog();
        Subscription rxSubscription = mRetrofitHelper.getFuliData()
                .compose(RxUtil.<FuLiGirl>rxSchedulerHelper())
                .subscribe(new Action1<FuLiGirl>() {
                    @Override
                    public void call(FuLiGirl commentBean) {
                        mView.showFuliGirl(commentBean);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.showTest("数据加载失败ヽ(≧Д≦)ノ");
                    }
                });
        addSubscrebe(rxSubscription);
    }
}
