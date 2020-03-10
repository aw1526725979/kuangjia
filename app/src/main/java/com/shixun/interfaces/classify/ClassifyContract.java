package com.shixun.interfaces.classify;

import com.shixun.interfaces.IBasePersenter;
import com.shixun.interfaces.IBaseView;
import com.shixun.model.bean.SortBean;
import com.shixun.model.bean.SortDetailGoodsBean;
import com.shixun.model.bean.SortDetailTabBean;
import com.shixun.model.bean.SortGoodsBean;

public interface ClassifyContract {

    interface View extends IBaseView{

        void getSortReturn(SortBean result);

        void getCurrentSortDataReturn(SortGoodsBean result);

    }

    interface Persenter extends IBasePersenter<View>{
        void getSort();
        void getCurrentSortData(int id);
    }
    interface DetailView extends IBaseView{

        void getSortDetailTabReturn(SortDetailTabBean result);

        void getSortDetailGoodsReturn(SortDetailGoodsBean result);

    }

    interface DetailPersenter extends IBasePersenter<DetailView>{
        //获取分类详情页的导航列表数据
        void getSortDetailTab(int id);
        //获取分类详情页当前的商品列表数据
        void getSortDetailGoods(int id,int page,int size);
    }
}