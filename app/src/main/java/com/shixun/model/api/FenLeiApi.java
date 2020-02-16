package com.shixun.model.api;

import com.shixun.model.bean.FenLeiBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface FenLeiApi {

    @GET("catalog/index")
    Flowable<FenLeiBean> getFenLeiBean();
}
