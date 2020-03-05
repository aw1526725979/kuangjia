package com.shixun.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shixun.R;
import com.shixun.base.BaseAdapter;
import com.shixun.model.bean.IndexBean;


import java.util.List;
//新品首发
public class Rec_home_newstartingAdapter extends BaseAdapter {
    public Rec_home_newstartingAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.item_home;
    }

    @Override
    public void bindData(com.shixun.base.BaseAdapter.BaseViewHolder holder, Object o) {
        IndexBean.DataBean.NewGoodsListBean bean = (IndexBean.DataBean.NewGoodsListBean) o;
        ImageView img_news = (ImageView)holder.getView(R.id.iv_item_shouye_yisi);
        TextView txt_name = (TextView)holder.getView(R.id.tv_item_shouye_yisiname);
        TextView txt_price = (TextView)holder.getView(R.id.tv_item_shouye_yisiprice);
        //数据填充
        Glide.with(mContext).load(bean.getList_pic_url()).into(img_news);
        txt_name.setText(bean.getName());
        String price = mContext.getResources().getString(R.string.price_news_model);
        txt_price.setText(price.replace("$",bean.getRetail_price()));
    }
}

