package com.shixun.persenter.cart;


import com.shixun.Utils.RxUtils;
import com.shixun.base.BasePersenter;
import com.shixun.interfaces.Cart.CartConstart;
import com.shixun.model.CommonSubscriber;
import com.shixun.model.bean.RelatedBean;
import com.shixun.model.http.HttpManager;

public class CartPersenter extends BasePersenter<CartConstart.View> implements CartConstart.Persenter {

    //获取商品购买页面的数据
    @Override
    public void getRelatedData(int id) {
        addSubscribe(HttpManager.getInstance().getShopApi().getRelatedData(id)
        .compose(RxUtils.<RelatedBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<RelatedBean>(mView){

            @Override
            public void onNext(RelatedBean relatedBean) {
                mView.getRelatedDataReturn(relatedBean);
            }
        }));
    }

}
