package com.shixun.interfaces.home;


import com.shixun.interfaces.IBasePersenter;
import com.shixun.interfaces.IBaseView;
import com.shixun.model.bean.BrandBean;
import com.shixun.model.bean.BrandGoodsBean;

public interface BrandConstract {

    interface View extends IBaseView {
        //获取品牌详情页数据返回
        void getBrandInfoReturn(BrandBean result);
        //获取品牌详情页的商品列表返回
        void getBrandGoodsReturn(BrandGoodsBean result);
    }
    interface Persenter extends IBasePersenter<View> {
        //获取品牌详情页数据
        void getBrandInfo(String id);
        //获取品牌详情页的商品列表数据
        void getBrandGoods(String brandId, int page, int size);
    }

}
