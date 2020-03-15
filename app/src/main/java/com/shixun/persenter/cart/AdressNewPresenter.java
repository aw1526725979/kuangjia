package com.shixun.persenter.cart;



import com.shixun.Utils.RxUtils;
import com.shixun.base.BasePersenter;
import com.shixun.interfaces.Cart.ShoppingConstact;
import com.shixun.model.CommonSubscriber;
import com.shixun.model.bean.AdressSaveBean;
import com.shixun.model.bean.RegionBean;
import com.shixun.model.http.HttpManager;

import java.util.Map;

public class AdressNewPresenter extends BasePersenter<ShoppingConstact.AdressNewView> implements ShoppingConstact.AdressNewPresenter{

    //保存地址
    @Override
    public void saveAdress(Map map) {
        addSubscribe(HttpManager.getInstance().getShopApi().saveAdress(map)
                .compose(RxUtils.<AdressSaveBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<AdressSaveBean>(mView){

                    @Override
                    public void onNext(AdressSaveBean saveBean) {
                        mView.saveAdressReturn(saveBean);
                    }
                }));
    }

    //获取省市区数据
    @Override
    public void getRegion(int parentId) {
        addSubscribe(HttpManager.getInstance().getShopApi().getRegion(parentId)
                .compose(RxUtils.<RegionBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<RegionBean>(mView){

                    @Override
                    public void onNext(RegionBean regionBean) {
                        mView.getRegionReturn(regionBean);
                    }
                }));
    }
}
