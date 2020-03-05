package com.shixun.persenter;


import com.shixun.Utils.RxUtils;
import com.shixun.base.BasePersenter;
import com.shixun.interfaces.fenleiitem.FenLeiItemContract;
import com.shixun.model.CommonSubscriber;
import com.shixun.model.bean.SortDetailTabBean;
import com.shixun.model.bean.SortGoodsBean;
import com.shixun.model.http.HttpManager;

public class FenLeiItemPersenter extends BasePersenter<FenLeiItemContract.View> implements FenLeiItemContract.Persenter {
    @Override
    public void getFenLeiItemData(int id) {
        addSubscribe(HttpManager.getInstance().getShopApi().getSortDetailTab(id)
                .compose(RxUtils.<SortDetailTabBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<SortDetailTabBean>(mView){
                    @Override
                    public void onNext(SortDetailTabBean sortDetailTabBean) {
                        mView.FenLeiItemDataReturn(sortDetailTabBean);
                    }
                }));
    }
}
