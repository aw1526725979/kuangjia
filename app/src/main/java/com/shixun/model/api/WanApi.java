package com.shixun.model.api;


import com.shixun.model.bean.ChaptersBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface WanApi {

    @GET("wxarticle/chapters/json")
    Flowable<ChaptersBean> getChapters();


}
