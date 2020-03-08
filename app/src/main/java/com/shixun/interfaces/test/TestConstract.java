package com.shixun.interfaces.test;


import com.shixun.interfaces.IBasePersenter;
import com.shixun.interfaces.IBaseView;
import com.shixun.model.bean.ChaptersBean;

public interface TestConstract {

    interface View extends IBaseView {
        void getChaptersReturn(ChaptersBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        void getChapters();
    }

}
