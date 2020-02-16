package com.shixun.persenter;


import com.shixun.Utils.RxUtils;
import com.shixun.base.BasePersenter;
import com.shixun.interfaces.fenleiitem.FenLeiItemContract;
import com.shixun.model.CommonSubscriber;
import com.shixun.model.bean.FenLei_TabBean;
import com.shixun.model.http.HttpManager;

public class FenLeiItemPersenter extends BasePersenter<FenLeiItemContract.View> implements FenLeiItemContract.Persenter {
    @Override
    public void getFenLeiItemData(int id) {
        addSubscribe(HttpManager.getFenLeiItemApi().getFenLeitemBean(id)
                .compose(RxUtils.<FenLei_TabBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<FenLei_TabBean>(mView){
                    @Override
                    public void onNext(FenLei_TabBean fenLei_tabBean) {
                        mView.FenLeiItemDataReturn(fenLei_tabBean);
                    }
                }));
    }
}
