package com.shixun.view.classify.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;
import com.shixun.R;
import com.shixun.base.BaseActivity;
import com.shixun.base.BaseAdapter;
import com.shixun.common.RecycleGridDivider;
import com.shixun.interfaces.IBasePersenter;
import com.shixun.interfaces.classify.ClassifyContract;
import com.shixun.model.bean.SortDetailGoodsBean;
import com.shixun.model.bean.SortDetailTabBean;
import com.shixun.persenter.classify.FenLeiItemPersenter;
import com.shixun.view.Cart.GoodInfoActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.shixun.interfaces.classify.ClassifyContract.*;

public class SortDetailActivity extends BaseActivity<ClassifyContract.DetailPersenter>implements DetailView,
        TabLayout.OnTabSelectedListener,BaseAdapter.ItemClickHandler{
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.txt_des)
    TextView txtDes;
    @BindView(R.id.layout_infos)
    ConstraintLayout layoutInfos;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    List<SortDetailTabBean.DataBean.BrotherCategoryBean> tabs;
    List<SortDetailGoodsBean.DataBeanX.GoodsListBean> goodsList;
    DetailGoodsAdapter detailGoodsAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_sort_detail;
    }

    @Override
    protected void initView() {
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.addOnTabSelectedListener(this);
        goodsList = new ArrayList<>();
        detailGoodsAdapter = new DetailGoodsAdapter(goodsList, this);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(detailGoodsAdapter);
        recyclerView.addItemDecoration(new RecycleGridDivider());
        detailGoodsAdapter.setOnItemClickHandler(this);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {
        int id = getIntent().getIntExtra("sortId", 0);
        persenter.getSortDetailTab(id);
    }

    @Override
    protected DetailPersenter createPersenter() {
        return new FenLeiItemPersenter();
    }

    @Override
    public void getSortDetailTabReturn(SortDetailTabBean result) {

        int position = -1;
        tabs = result.getData().getBrotherCategory();
        //动态添加tab导航的内容
        for (int i = 0; i < result.getData().getBrotherCategory().size(); i++) {
            SortDetailTabBean.DataBean.BrotherCategoryBean item = result.getData().getBrotherCategory().get(i);
            TabLayout.Tab tab = tabLayout.newTab();
            tab.setText(item.getName());
            tab.setTag(item.getId());
            tabLayout.addTab(tab);

            if (result.getData().getCurrentCategory().getId() == item.getId()) {
                position = i;
            }
        }
        if (position >= 0) {
            tabLayout.getTabAt(position).select();
        }
    }

    @Override
    public void getSortDetailGoodsReturn(SortDetailGoodsBean result) {
        detailGoodsAdapter.updata(result.getData().getGoodsList());
    }

    //选中tab
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        //刷新显示的名字描述信息
        SortDetailTabBean.DataBean.BrotherCategoryBean bean = tabs.get(tab.getPosition());
        txtName.setText(bean.getFront_name());
        txtDes.setText(bean.getFront_desc());
        int id = (int) tab.getTag();
        //获取商品列表数据
        persenter.getSortDetailGoods(id, 1, 1000);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
    }
    //处理接口回调
    @Override
    public void itemClick(int position, BaseAdapter.BaseViewHolder holder) {
        int id = goodsList.get(position).getId();
        Intent intent = new Intent(this, GoodInfoActivity.class);
        intent.putExtra("relatedId", id);
        startActivity(intent);
    }

    @Override
    public void showTips(String msg) {

    }
}
