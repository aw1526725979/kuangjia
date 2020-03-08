package com.shixun.persenter.classify;


import com.shixun.Utils.RxUtils;
import com.shixun.base.BasePersenter;
import com.shixun.interfaces.classify.ClassifyContract;
import com.shixun.model.CommonSubscriber;
import com.shixun.model.bean.SortBean;
import com.shixun.model.bean.SortGoodsBean;
import com.shixun.model.http.HttpManager;

public class FenLeiPersenter extends BasePersenter<ClassifyContract.View> implements ClassifyContract.Persenter{


    @Override
    public void getSort() {
        addSubscribe(HttpManager.getInstance().getShopApi().getSort()
                .compose(RxUtils.<SortBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<SortBean>(mView) {
                    @Override
                    public void onNext(SortBean sortBean) {
                        mView.getSortReturn(sortBean);
                    }
                }));
    }

    @Override
    public void getCurrentSortData(int id) {
        addSubscribe(HttpManager.getInstance().getShopApi().getCurrentSortData(id)
                .compose(RxUtils.<SortGoodsBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<SortGoodsBean>(mView) {
                    @Override
                    public void onNext(SortGoodsBean sortGoodsBean) {
                        mView.getCurrentSortDataReturn(sortGoodsBean);
                    }
                }));
    }
}
