package com.shixun.interfaces.fenlei;

import com.shixun.interfaces.IBasePersenter;
import com.shixun.interfaces.IBaseView;
import com.shixun.model.bean.SortBean;

public interface FenLeiContract {
    interface View extends IBaseView {
        void FenLeiDataReturn(SortBean sortBean);
    }

    interface Persenter extends IBasePersenter<View> {
        void getFenLeiData();
    }
}
