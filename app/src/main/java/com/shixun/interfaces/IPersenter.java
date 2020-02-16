package com.shixun.interfaces;

public interface IPersenter<V extends IBaseView> {

    void attchView(V view);

    void detachView();

}

