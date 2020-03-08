package com.shixun.view.home;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.shixun.R;
import com.shixun.adapter.Rec_home_newstartingAdapter;
import com.shixun.adapter.Rec_home_brandAdapter;
import com.shixun.base.BaseAdapter;

import com.shixun.base.BaseFragment;
import com.shixun.interfaces.home.HomeContract;
import com.shixun.model.bean.IndexBean;
import com.shixun.persenter.home.HomePersenter;
import com.shixun.view.home.activity.BrandActivity;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment<HomeContract.Persenter> implements HomeContract.View, BaseAdapter.ItemClickHandler {
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.recyclerView_News)
    RecyclerView recyclerViewNews;

    Rec_home_brandAdapter brandAdapter;
    List<IndexBean.DataBean.BrandListBean> list;

    Rec_home_newstartingAdapter newsAdapter;
    List<IndexBean.DataBean.NewGoodsListBean> newsList;

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    protected void initView() {
        list = new ArrayList<>();
        brandAdapter = new Rec_home_brandAdapter(list, context);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        recyclerView.setAdapter(brandAdapter);
        brandAdapter.setOnItemClickHandler(this);

        //初始化新品列表
        newsList = new ArrayList<>();
        newsAdapter = new Rec_home_newstartingAdapter(newsList, context);
        recyclerViewNews.setLayoutManager(new GridLayoutManager(context, 2));
        recyclerViewNews.setAdapter(newsAdapter);
        //避免当前类中多个列表的点击接口回调的冲突，建议使用匿名的类实例
        newsAdapter.setOnItemClickHandler(new BaseAdapter.ItemClickHandler() {
            @Override
            public void itemClick(int position, BaseAdapter.BaseViewHolder holder) {
                Log.i("newsItemClick", String.valueOf(position));
            }
        });

    }

    @Override
    protected void initData() {
        persenter.getHomeData();
    }

    @Override
    protected HomeContract.Persenter createPersenter() {
        return new HomePersenter();
    }

    @Override
    public void getHomeDataReturn(IndexBean result) {
        List<IndexBean.DataBean.BannerBean> banners = new IndexBean().getData().getBanner();
        //banner图片资源的集合
        final ArrayList<String> imgs = new ArrayList<>();
        for (int i = 0; i < banners.size(); i++) {
            String image_url = banners.get(i).getImage_url();
            imgs.add(image_url);

            //banner轮播图的实现
            banner.setImages(imgs).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(context).load((String) path).into(imageView);
                }
            }).start();

            //banner的点击监听
            banner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {

                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });

            //刷新Brand列表数据
            brandAdapter.updata(result.getData().getBrandList());
            //刷新新品发布列表数据
            newsAdapter.updata(result.getData().getNewGoodsList());
        }


    }
    /**
     * 接口回调的方法
     * @param position
     * @param holder
     */
    @Override
    public void itemClick(int position, BaseAdapter.BaseViewHolder holder) {
        IndexBean.DataBean.BrandListBean bean = list.get(position);
        ((TextView)holder.getView(R.id.txt_name)).setText(bean.getName()+"新的名字");
        Log.i("brand-click",String.valueOf(position));
        //跳转到brand详情页
        Intent intent = new Intent(getContext(), BrandActivity.class);
        intent.putExtra("brandId",bean.getId());
        startActivity(intent);
    }

    @Override
    public void showTips(String msg) {

    }
}

