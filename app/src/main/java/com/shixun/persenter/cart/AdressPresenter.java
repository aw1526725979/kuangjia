package com.shixun.persenter.cart;


import com.shixun.Utils.RxUtils;
import com.shixun.base.BasePersenter;
import com.shixun.interfaces.Cart.ShoppingConstact;
import com.shixun.model.CommonSubscriber;
import com.shixun.model.bean.AddressBean;
import com.shixun.model.http.HttpManager;

public class AdressPresenter extends BasePersenter<ShoppingConstact.AdressView> implements ShoppingConstact.AdressPresenter {

    @Override
    public void getAdressList() {
        addSubscribe(HttpManager.getInstance().getShopApi().getAddress()
        .compose(RxUtils.<AddressBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<AddressBean>(mView){

            @Override
            public void onNext(AddressBean addressBean) {
                mView.getAdressListReturn(addressBean);
            }
        }));
    }
}
