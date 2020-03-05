package com.shixun.persenter;


import com.shixun.Utils.RxUtils;
import com.shixun.base.BasePersenter;
import com.shixun.interfaces.fenlei.FenLeiContract;
import com.shixun.model.CommonSubscriber;
import com.shixun.model.bean.SortBean;
import com.shixun.model.http.HttpManager;

public class FenLeiPersenter extends BasePersenter<FenLeiContract.View> implements FenLeiContract.Persenter{

    @Override
    public void getFenLeiData() {
        addSubscribe(HttpManager.getInstance().getShopApi().getSort()
                .compose(RxUtils.<SortBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<SortBean>(mView){
                    @Override
                    public void onNext(SortBean sortBean) {
                        mView.FenLeiDataReturn(sortBean);
                    }
                }));
    }
}
