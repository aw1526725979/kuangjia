package com.shixun.interfaces.fenleiitem;


import com.shixun.interfaces.IBasePersenter;
import com.shixun.interfaces.IBaseView;
import com.shixun.model.bean.SortBean;
import com.shixun.model.bean.SortDetailTabBean;
import com.shixun.model.bean.SortGoodsBean;

public interface FenLeiItemContract {
    interface View extends IBaseView {
        void FenLeiItemDataReturn(SortBean sortBean);
    }

    interface Persenter extends IBasePersenter<View> {
        void getFenLeiItemData(int id);
    }
}
