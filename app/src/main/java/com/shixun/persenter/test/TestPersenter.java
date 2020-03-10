package com.shixun.persenter.test;


import com.shixun.Utils.RxUtils;
import com.shixun.base.BasePersenter;
import com.shixun.common.CommonSubscriber;
import com.shixun.interfaces.test.TestConstract;
import com.shixun.model.bean.ChaptersBean;
import com.shixun.model.http.HttpManager;

public class TestPersenter extends BasePersenter<TestConstract.View> implements TestConstract.Persenter {

    @Override
    public void getChapters() {
        addSubscribe(HttpManager.getInstance().getWanApi().getChapters()
        .compose(RxUtils.<ChaptersBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<ChaptersBean>(mView){

            @Override
            public void onNext(ChaptersBean chaptersBean) {
                mView.getChaptersReturn(chaptersBean);
            }
        }));

        //网络请求不用背压式
        /*HttpManager.getInstance().getWanApi().getChapters()
                .compose(RxUtils.<ChaptersBean>rxScheduler())
                .subscribeWith(new ResourceSubscriber<ChaptersBean>() {
                    @Override
                    public void onNext(ChaptersBean chaptersBean) {

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });*/
    }

}
