package com.shixun.persenter.home;


import com.shixun.Utils.RxUtils;
import com.shixun.base.BasePersenter;
import com.shixun.interfaces.home.BrandConstract;
import com.shixun.model.CommonSubscriber;
import com.shixun.model.bean.BrandBean;
import com.shixun.model.bean.BrandGoodsBean;
import com.shixun.model.http.HttpManager;

public class BrandPersenter extends BasePersenter<BrandConstract.View> implements BrandConstract.Persenter {


    @Override
    public void getBrandInfo(String id) {
        addSubscribe(HttpManager.getInstance().getShopApi().getBrandInfo(id)
        .compose(RxUtils.<BrandBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<BrandBean>(mView){

            @Override
            public void onNext(BrandBean brandBean) {
                mView.getBrandInfoReturn(brandBean);
            }
        }));
    }

    @Override
    public void getBrandGoods(String brandId, int page, int size) {
        addSubscribe(HttpManager.getInstance().getShopApi().getBrandGoods(brandId,page,size)
                .compose(RxUtils.<BrandGoodsBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<BrandGoodsBean>(mView){

                    @Override
                    public void onNext(BrandGoodsBean brandGoodsBean) {
                        mView.getBrandGoodsReturn(brandGoodsBean);
                    }
                }));
    }
}
