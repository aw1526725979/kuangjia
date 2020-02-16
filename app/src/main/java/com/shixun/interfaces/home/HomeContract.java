package com.shixun.interfaces.home;


import com.shixun.interfaces.IBaseView;
import com.shixun.interfaces.IPersenter;
import com.shixun.model.bean.ShouYeBean;

public interface HomeContract {
    interface View extends IBaseView{
        void HomeDataReturn(ShouYeBean shouYeBean);
    }

    interface Persenter extends IPersenter<View>{
        void getHomeData();
    }
}