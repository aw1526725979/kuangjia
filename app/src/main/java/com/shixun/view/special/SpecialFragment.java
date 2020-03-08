package com.shixun.view.special;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.shixun.R;
import com.shixun.adapter.Rec_specialAdapter;
import com.shixun.base.BaseFragment;
import com.shixun.interfaces.IBasePersenter;
import com.shixun.interfaces.home.HomeContract;
import com.shixun.model.bean.IndexBean;
import com.shixun.persenter.home.HomePersenter;

import java.util.ArrayList;
import java.util.List;

public class SpecialFragment extends BaseFragment implements HomeContract.View {

    private RecyclerView rec;
    private List<IndexBean.DataBean.TopicListBean> list;
    private Rec_specialAdapter adapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_special;
    }

    @Override
    protected void initView() {

    }

    protected void initView(View view) {
        rec = view.findViewById(R.id.rec_zhuanti);
        rec.setLayoutManager(new LinearLayoutManager(context));
        list = new ArrayList<>();
        adapter = new Rec_specialAdapter(list, context);
        rec.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        persenter.getHomeData();
    }

    @Override
    protected IBasePersenter<HomeContract.View> createPersenter() {
        return new HomePersenter();
    }

    @Override
    public void getHomeDataReturn(IndexBean indexBean) {
        List<IndexBean.DataBean.TopicListBean> topicList = indexBean.getData().getTopicList();
        list.addAll(topicList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showTips(String msg) {

    }
}
