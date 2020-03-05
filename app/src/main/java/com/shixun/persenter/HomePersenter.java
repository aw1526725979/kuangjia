package com.shixun.persenter;


import com.shixun.Utils.RxUtils;
import com.shixun.base.BasePersenter;
import com.shixun.interfaces.home.HomeContract;
import com.shixun.model.CommonSubscriber;
import com.shixun.model.bean.IndexBean;
import com.shixun.model.http.HttpManager;

public class HomePersenter extends BasePersenter<HomeContract.View> implements HomeContract.Persenter {

    //获取主页的具体实现
    @Override
    public void getHomeData() {
        addSubscribe(HttpManager.getInstance().getShopApi().getIndexData()
                .compose(RxUtils.<IndexBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<IndexBean>(mView){

                    @Override
                    public void onNext(IndexBean indexBean) {
                        mView.getHomeDataReturn(indexBean);
                    }
                }));
    }

}
