package com.shixun.model.api;

import com.shixun.model.bean.ShouYeBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface HomeApi {

    @GET("api/index/index")
    Flowable<ShouYeBean> getShouYeBean();
}
