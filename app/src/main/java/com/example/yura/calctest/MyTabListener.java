package com.example.yura.calctest;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;

/**
 * Created by Yura on 18.04.2015.
 */
public class MyTabListener implements ActionBar.TabListener {
    Fragment fragment;
    public MyTabListener(Fragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        ft.replace(R.id.fragment_container, fragment);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        ft.remove(fragment);
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
