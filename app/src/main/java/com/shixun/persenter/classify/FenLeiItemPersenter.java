package com.shixun.persenter.classify;


import com.shixun.Utils.RxUtils;
import com.shixun.base.BasePersenter;
import com.shixun.interfaces.classify.ClassifyContract;

import com.shixun.model.CommonSubscriber;
import com.shixun.model.bean.SortDetailGoodsBean;
import com.shixun.model.bean.SortDetailTabBean;
import com.shixun.model.bean.SortGoodsBean;
import com.shixun.model.http.HttpManager;
//FenLeiItemPersenter
public class FenLeiItemPersenter extends BasePersenter<ClassifyContract.DetailView> implements ClassifyContract.DetailPersenter {

    @Override
    public void getSortDetailTab(int id) {
        addSubscribe(HttpManager.getInstance().getShopApi().getSortDetailTab(id)
                .compose(RxUtils.<SortDetailTabBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<SortDetailTabBean>(mView){
                    @Override
                    public void onNext(SortDetailTabBean sortDetailTabBean) {
                        mView.getSortDetailTabReturn(sortDetailTabBean);
                    }
                }));
    }

    @Override
    public void getSortDetailGoods(int id, int page, int size) {
        addSubscribe(HttpManager.getInstance().getShopApi().getSortDetailGoods(id,page,size)
                .compose(RxUtils.<SortDetailGoodsBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<SortDetailGoodsBean>(mView){
                    @Override
                    public void onNext(SortDetailGoodsBean sortDetailGoodsBean) {
                        mView.getSortDetailGoodsReturn(sortDetailGoodsBean);
                    }
                }));
    }

}
