package com.hackhome.legendassistant.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
public class BaseFragmentPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mFragments;
    private ArrayList<String> mTitles;


    public BaseFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.mFragments = fragments;
    }

    public void setTitles(ArrayList<String> titles) {
        this.mTitles = titles;
        this.notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments == null ? 0 : mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }




}
