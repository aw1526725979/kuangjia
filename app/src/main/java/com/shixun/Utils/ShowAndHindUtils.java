package com.shixun.Utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.shixun.MainActivity;


public class ShowAndHindUtils {
    public static void showhind(MainActivity mainActivity, Fragment showFragment, Fragment old){
        FragmentTransaction ft = mainActivity.getSupportFragmentManager().beginTransaction();
        ft.show(showFragment).hide(old).commit();
    }
}
