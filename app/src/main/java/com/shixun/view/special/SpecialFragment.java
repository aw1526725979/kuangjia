package com.shixun.view.special;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.shixun.R;
import com.shixun.adapter.Rec_zhuantiAdapter;
import com.shixun.base.BaseFragment;
import com.shixun.interfaces.IPersenter;
import com.shixun.interfaces.home.HomeContract;
import com.shixun.model.bean.ShouYeBean;
import com.shixun.persenter.HomePersenter;

import java.util.ArrayList;
import java.util.List;

public class SpecialFragment extends BaseFragment implements HomeContract.View {


    private RecyclerView rec;
    private List<ShouYeBean.DataBean.TopicListBean> list;
    private Rec_zhuantiAdapter adapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_special;
    }

    @Override
    protected void initView(View view) {
        rec = view.findViewById(R.id.rec_zhuanti);
        rec.setLayoutManager(new LinearLayoutManager(context));
        list = new ArrayList<>();
        adapter = new Rec_zhuantiAdapter(list, context);
        rec.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        ((HomePersenter)persenter).getHomeData();
    }

    @Override
    protected IPersenter createPersenter() {
        return new HomePersenter();
    }

    @Override
    public void HomeDataReturn(ShouYeBean shouYeBean) {
        List<ShouYeBean.DataBean.TopicListBean> topicList = shouYeBean.getData().getTopicList();
        list.addAll(topicList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError(String err) {

    }
}