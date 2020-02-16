package com.shixun.model.api;

import com.shixun.model.bean.FenLei_TabBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FenLeiItenApi {
    @GET("catalog/index")
    Flowable<FenLei_TabBean> getFenLeitemBean(@Query("id") int id);
}
