package com.shixun.persenter;


import com.shixun.Utils.RxUtils;
import com.shixun.base.BasePersenter;
import com.shixun.interfaces.fenlei.FenLeiContract;
import com.shixun.model.CommonSubscriber;
import com.shixun.model.bean.FenLeiBean;
import com.shixun.model.http.HttpManager;

public class FenLeiPersenter extends BasePersenter<FenLeiContract.View> implements FenLeiContract.Persenter{

    @Override
    public void getFenLeiData() {
        addSubscribe(HttpManager.getFenLeiApi().getFenLeiBean()
                .compose(RxUtils.<FenLeiBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<FenLeiBean>(mView){
                    @Override
                    public void onNext(FenLeiBean fenLeiBean) {
                        mView.FenLeiDataReturn(fenLeiBean);
                    }
                }));
    }
}
