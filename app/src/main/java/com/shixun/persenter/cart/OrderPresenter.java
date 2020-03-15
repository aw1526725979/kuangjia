package com.shixun.persenter.cart;


import com.shixun.Utils.RxUtils;
import com.shixun.base.BasePersenter;
import com.shixun.interfaces.Cart.ShoppingConstact;
import com.shixun.model.CommonSubscriber;
import com.shixun.model.bean.OrderInfoBean;
import com.shixun.model.http.HttpManager;

public class OrderPresenter extends BasePersenter<ShoppingConstact.OrderView> implements ShoppingConstact.OrderPresenter {

    //获取订单信息
    @Override
    public void getOrderList(int addressId, int couponId) {
        addSubscribe(HttpManager.getInstance().getShopApi().getOrderInfo(addressId,couponId)
        .compose(RxUtils.<OrderInfoBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<OrderInfoBean>(mView){
            @Override
            public void onNext(OrderInfoBean orderInfoBean) {
                mView.getOrderListReturn(orderInfoBean);
            }
        }));
    }
}
