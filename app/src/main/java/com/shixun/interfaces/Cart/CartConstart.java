package com.shixun.interfaces.Cart;


import com.shixun.interfaces.IBasePersenter;
import com.shixun.interfaces.IBaseView;
import com.shixun.model.bean.RelatedBean;

public interface CartConstart {

    interface View extends IBaseView {
        void getRelatedDataReturn(RelatedBean result);
    }

    interface Persenter extends IBasePersenter<View>{
        void getRelatedData(int id);
    }

}
