package com.shixun.interfaces.fenleiitem;


import com.shixun.interfaces.IBaseView;
import com.shixun.interfaces.IPersenter;
import com.shixun.model.bean.FenLei_TabBean;

public interface FenLeiItemContract {
    interface View extends IBaseView {
        void FenLeiItemDataReturn(FenLei_TabBean fenLei_tabBean);
    }

    interface Persenter extends IPersenter<View> {
        void getFenLeiItemData(int id);
    }
}
