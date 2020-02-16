package com.shixun;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;
import com.shixun.R;
import com.shixun.view.Cart.CartFragment;
import com.shixun.view.classify.ClassifyFragment;
import com.shixun.view.home.HomeFragment;
import com.shixun.view.own.OwnFragment;
import com.shixun.view.special.SpecialFragment;


public class MainActivity extends AppCompatActivity {

    HomeFragment homeFragment;
    OwnFragment ownFragment;
    SpecialFragment specialFragment;
    ClassifyFragment classifyFragment;
    CartFragment cartFragment;
    FrameLayout mFragmentBox;
    TabLayout mTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("                       仿网易严选");
        initView();



    }
    private void initView() {
        mFragmentBox = (FrameLayout) findViewById(R.id.fragmentBox);
        mTab = (TabLayout) findViewById(R.id.tab);

        homeFragment = new HomeFragment();
        specialFragment = new SpecialFragment();
        classifyFragment = new ClassifyFragment();
        cartFragment = new CartFragment();
        ownFragment = new OwnFragment();

        mTab.addTab(mTab.newTab().setText("首页").setIcon(R.drawable.selector_home));
        mTab.addTab(mTab.newTab().setText("专题").setIcon(R.drawable.selector_special));
        mTab.addTab(mTab.newTab().setText("分类").setIcon(R.drawable.selector_classify));
        mTab.addTab(mTab.newTab().setText("购物车").setIcon(R.drawable.selector_cart));
        mTab.addTab(mTab.newTab().setText("我的").setIcon(R.drawable.selector_own));

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentBox,homeFragment)
                .add(R.id.fragmentBox, specialFragment)
                .add(R.id.fragmentBox,classifyFragment)
                .add(R.id.fragmentBox,cartFragment)
                .add(R.id.fragmentBox,ownFragment)
                .hide(specialFragment)
                .hide(classifyFragment)
                .hide(cartFragment)
                .hide(ownFragment)
                .commit();

        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (position) {
                    case 0:
                        getSupportFragmentManager().beginTransaction()
                                .show( homeFragment)
                                .hide(specialFragment)
                                .hide(classifyFragment)
                                .hide(cartFragment)
                                .hide(ownFragment)
                                .commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction()
                                .show( specialFragment)
                                .hide( homeFragment)
                                .hide(classifyFragment)
                                .hide(cartFragment)
                                .hide(ownFragment)
                                .commit();
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction()
                                .show( classifyFragment)
                                .hide( homeFragment)
                                .hide(specialFragment)
                                .hide(cartFragment)
                                .hide(ownFragment)
                                .commit();
                        break;
                    case 3:
                        getSupportFragmentManager().beginTransaction()
                                .show( cartFragment)
                                .hide( homeFragment)
                                .hide(specialFragment)
                                .hide(classifyFragment)
                                .hide(ownFragment)
                                .commit();
                        break;
                    case 4:
                        getSupportFragmentManager().beginTransaction()
                                .show( ownFragment)
                                .hide( homeFragment)
                                .hide(specialFragment)
                                .hide(classifyFragment)
                                .hide(cartFragment)
                                .commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
