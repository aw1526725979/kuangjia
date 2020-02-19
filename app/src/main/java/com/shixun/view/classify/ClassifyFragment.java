package com.shixun.view.classify;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;
import android.widget.EditText;

import com.shixun.R;
import com.shixun.base.BaseFragment;
import com.shixun.interfaces.IPersenter;
import com.shixun.interfaces.fenlei.FenLeiContract;
import com.shixun.model.bean.FenLeiBean;
import com.shixun.persenter.FenLeiPersenter;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.TabView;

public class ClassifyFragment extends BaseFragment implements FenLeiContract.View {
    private EditText etFenlei;
    private VerticalTabLayout tabFenlei;
    private Fragment oidFragment;
    private int posi = 0;

    @Override
    protected int getLayout() {
        return R.layout.fragment_classify;
    }

    @Override
    protected void initView(View view) {
        etFenlei = (EditText) view.findViewById(R.id.et_fenlei);
        tabFenlei = (VerticalTabLayout) view.findViewById(R.id.tab_fenlei);
    }


    @Override
    protected void initData() {
        ((FenLeiPersenter)persenter).getFenLeiData();
    }

    @Override
    protected IPersenter createPersenter() {
        return new FenLeiPersenter();
    }

    @Override
    public void FenLeiDataReturn(FenLeiBean fenLeiBean) {
        final List<FenLeiBean.DataBean.CategoryListBean> categoryList = fenLeiBean.getData().getCategoryList();
        //定义tab集合
        final ArrayList<String> tabs = new ArrayList<>();

        //定义fragment集合
        final ArrayList<Fragment> fragments = new ArrayList<>();


        for (int i = 0; i < categoryList.size(); i++) {
            String name = categoryList.get(i).getName();
            tabs.add(name);
            //碎片传值
            classify_Fragment fenLei_fragment = new classify_Fragment();
            Bundle bund = new Bundle();
            bund.putInt("key",categoryList.get(i).getId());
            fenLei_fragment.setArguments(bund);
            fragments.add(fenLei_fragment);
        }
        //开启Fragment事务  控制Fragment显示隐藏
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        for (int i = 0; i < fragments.size(); i++) {
            ft.add(R.id.fl_fenlei,fragments.get(i)).hide(fragments.get(i));
        }
        oidFragment = fragments.get(0);
        ft.show(oidFragment).commit();

        //tab的适配器
        tabFenlei.setTabAdapter(new TabAdapter() {
            @Override
            public int getCount() {
                return tabs.size();
            }

            @Override
            public ITabView.TabBadge getBadge(int position) {
                return null;
            }

            @Override
            public ITabView.TabIcon getIcon(int position) {
                return null;
            }

            @Override
            public ITabView.TabTitle getTitle(int position) {
                ITabView.TabTitle title = new ITabView.TabTitle.Builder()
                        .setContent(tabs.get(position))//从集合中获取标题
                        .setTextColor(Color.RED,Color.BLACK)
                        .build();
                return title;
            }

            @Override
            public int getBackground(int position) {
                return 0;
            }
        });

        //tab的点击监听
        tabFenlei.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                posi = position;
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.show(fragments.get(position)).hide(oidFragment).commit();
                EventBus.getDefault().post(position+"");
                oidFragment = fragments.get(position);
            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError(String err) {

    }
}
