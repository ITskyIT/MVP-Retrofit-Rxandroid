package com.tian.mvpdemo.presenter;

import com.tian.mvpdemo.base.BaseRx;
import com.tian.mvpdemo.bean.GirlBean;
import com.tian.mvpdemo.model.impl.GirlModeImpl;
import com.tian.mvpdemo.model.IGirlMode;
import com.tian.mvpdemo.view.IGirlView;

import java.util.List;

/**
 * Created by jiujiu on 2016/11/1.
 */
public class GirlPresenterImpl extends BaseRx<IGirlView> {
    //mode引用
    IGirlMode iGirlMode=new GirlModeImpl();

    public void feat(){
        mView.showLoadDialog();
        if (iGirlMode!=null) {
            iGirlMode.LoadGirl(new IGirlMode.OnLoadingListener() {
                @Override
                public void onLoadComplete(List<GirlBean> girls) {
                    mView.showGirl(girls);
                    mView.showTest("加载完成测试");
                }
            });
        }
    }
}
