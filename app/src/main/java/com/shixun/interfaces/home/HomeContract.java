package com.shixun.interfaces.home;


import com.shixun.interfaces.IBasePersenter;
import com.shixun.interfaces.IBaseView;
import com.shixun.model.bean.IndexBean;

public interface HomeContract {

    interface View extends IBaseView {
        void getHomeDataReturn(IndexBean indexBean);
    }

    interface Persenter extends IBasePersenter<View> {
        void getHomeData();
    }

}