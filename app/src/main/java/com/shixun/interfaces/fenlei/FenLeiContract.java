package com.shixun.interfaces.fenlei;

import com.shixun.interfaces.IBaseView;
import com.shixun.interfaces.IPersenter;
import com.shixun.model.bean.FenLeiBean;

public interface FenLeiContract {
    interface View extends IBaseView {
        void FenLeiDataReturn(FenLeiBean fenLeiBean);
    }

    interface Persenter extends IPersenter<View> {
        void getFenLeiData();
    }
}
