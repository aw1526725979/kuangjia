package com.shixun.persenter.login;


import com.shixun.Utils.RxUtils;
import com.shixun.base.BasePersenter;
import com.shixun.interfaces.IBaseView;
import com.shixun.interfaces.login.LoginConstract;
import com.shixun.model.CommonSubscriber;
import com.shixun.model.bean.UserBean;
import com.shixun.model.http.HttpManager;

public class LoginPersenter extends BasePersenter<LoginConstract.View> implements LoginConstract.Persenter {
    @Override
    public void login(String nickname, String password) {
        addSubscribe(HttpManager.getInstance().getShopApi().login(nickname,password)
                .compose(RxUtils.<UserBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<UserBean>(mView){

                    @Override
                    public void onNext(UserBean userBean) {
                        if(userBean.getErrno() == 0){
                            mView.loginReturn(userBean);
                        }else{
                            mView.showTips(userBean.getErrmsg());
                        }
                    }
                }));
    }
}
