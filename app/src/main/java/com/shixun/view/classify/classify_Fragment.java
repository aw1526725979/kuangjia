package com.shixun.view.classify;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.shixun.GoodsDescActivity;
import com.shixun.R;
import com.shixun.adapter.Rec_classifyAdapter;
import com.shixun.base.BaseFragment;
import com.shixun.interfaces.IBasePersenter;
import com.shixun.interfaces.fenleiitem.FenLeiItemContract;
import com.shixun.model.bean.SortBean;
import com.shixun.model.bean.SortDetailTabBean;
import com.shixun.persenter.FenLeiItemPersenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class classify_Fragment extends BaseFragment implements FenLeiItemContract.View {
    private List<SortBean.DataBean.CategoryListBean> tablist;
    private RecyclerView rec;
    private Rec_classifyAdapter adapter;
    private ImageView img_fenlei;
    private TextView tv_fenlei;
    private int posi = 0;

    @Override
    protected int getLayout() {
        if (!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
        return R.layout.fragment_classify_;
    }

    @Override
    protected void initView(View view) {
        rec = view.findViewById(R.id.rec_fenlei);
        img_fenlei = view.findViewById(R.id.iv_fenlei);
        tv_fenlei = view.findViewById(R.id.tv_fenlei_lei);
        rec.setLayoutManager(new GridLayoutManager(getActivity(),3));

        tablist = new ArrayList<>();
        adapter = new Rec_classifyAdapter(tablist, getActivity());
        rec.setAdapter(adapter);

        adapter.setOnClick(new Rec_classifyAdapter.OnClick() {
            @Override
            public void OnItemClick(int position) {
                ArrayList<SortBean.DataBean.CategoryListBean> list = new ArrayList<>();
                list.addAll(tablist);
                Intent intent = new Intent(context, GoodsDescActivity.class);
                intent.putExtra("data",list);
                intent.putExtra("posi",position);
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        ((FenLeiItemPersenter)persenter).getFenLeiItemData(posi);
    }

    @Subscribe
    public void getPosi(String position){
        posi = Integer.parseInt(position);
        ((FenLeiItemPersenter)persenter).getFenLeiItemData(posi);
    }

    @Override
    protected IBasePersenter<FenLeiItemContract.View> createPersenter() {
        return new FenLeiItemPersenter();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void showError(String err) {

    }

    @Override
    public void FenLeiItemDataReturn(SortBean sortBean) {
        List<SortBean.DataBean.CategoryListBean> categoryList = sortBean.getData().getCategoryList();
        tv_fenlei.setText(categoryList.get(posi).getFront_desc());
        Glide.with(context).load(categoryList.get(posi).getWap_banner_url()).into(img_fenlei);
        tablist.clear();
        tablist.addAll(categoryList);
        adapter.notifyDataSetChanged();
    }
}
