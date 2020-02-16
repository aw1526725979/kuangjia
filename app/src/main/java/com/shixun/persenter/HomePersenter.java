package com.shixun.persenter;


import com.shixun.Utils.RxUtils;
import com.shixun.base.BasePersenter;
import com.shixun.interfaces.home.HomeContract;
import com.shixun.model.CommonSubscriber;
import com.shixun.model.bean.ShouYeBean;
import com.shixun.model.http.HttpManager;

public class HomePersenter extends BasePersenter<HomeContract.View> implements HomeContract.Persenter{

    @Override
    public void getHomeData() {
        addSubscribe(HttpManager.getHomeApi().getShouYeBean()
                .compose(RxUtils.<ShouYeBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<ShouYeBean>(mView){
                    @Override
                    public void onNext(ShouYeBean shouYeBean) {
                        mView.HomeDataReturn(shouYeBean);
                    }
                }));
    }
}
