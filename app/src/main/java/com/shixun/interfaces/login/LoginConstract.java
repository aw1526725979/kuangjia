package com.shixun.interfaces.login;


import com.shixun.interfaces.IBasePersenter;
import com.shixun.interfaces.IBaseView;
import com.shixun.model.bean.UserBean;

public interface LoginConstract {

    interface View extends IBaseView{
        void loginReturn(UserBean result);
    }

    interface Persenter extends IBasePersenter<View>{
        void login(String nickname,String password);
    }
}
