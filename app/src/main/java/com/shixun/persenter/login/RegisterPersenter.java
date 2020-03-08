package com.shixun.persenter.login;


import com.shixun.Utils.RxUtils;
import com.shixun.base.BasePersenter;
import com.shixun.interfaces.login.RegisterConstract;
import com.shixun.model.CommonSubscriber;
import com.shixun.model.bean.VerifyBean;
import com.shixun.model.http.HttpManager;

public class RegisterPersenter extends BasePersenter<RegisterConstract.View> implements RegisterConstract.Persenter {
    @Override
    public void getVerify() {
        addSubscribe(HttpManager.getInstance().getShopApi().getVerify()
        .compose(RxUtils.<VerifyBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<VerifyBean>(mView){

            @Override
            public void onNext(VerifyBean verifyBean) {
                mView.getVerifyReturn(verifyBean);
            }
        }));
    }

}
