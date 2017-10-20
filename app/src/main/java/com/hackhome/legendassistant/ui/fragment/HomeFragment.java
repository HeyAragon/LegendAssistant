package com.hackhome.legendassistant.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hackhome.legendassistant.R;
import com.hackhome.legendassistant.ui.adapter.BaseFragmentPagerAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class HomeFragment extends Fragment{

    @BindView(R.id.home_tab_layout)
    TabLayout mHomeTabLayout;
    @BindView(R.id.home_search)
    ImageView mHomeSearch;
    @BindView(R.id.home_view_pager)
    ViewPager mHomeViewPager;

    private RecommendFragment mRecommendFragment;
    private RankingListFragment mRankingListFragment;
    private StrategyFragment mStrategyFragment;
    private ArrayList<Fragment> mFragments;
    private ArrayList<String> mTitles;
    private BaseFragmentPagerAdapter mBaseFragmentPagerAdapter;
    private Unbinder mBind;


    public static HomeFragment newInstance() {
        HomeFragment homeFragment = new HomeFragment();
        return homeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mBind = ButterKnife.bind(this, view);
        initFragment();
        initPagerAdapter();
        return view;
    }


    private void initFragment() {
        mFragments = new ArrayList<>();
        mRecommendFragment = RecommendFragment.newInstance();
        mRankingListFragment = RankingListFragment.newInstance();
        mStrategyFragment = StrategyFragment.newInstance();
        mFragments.add(mRecommendFragment);
        mFragments.add(mRankingListFragment);
        mFragments.add(mStrategyFragment);
    }

    private void initPagerAdapter() {
        mTitles = new ArrayList<>();
        mTitles.add(getResources().getString(R.string.tab_title_recommend));
        mTitles.add(getResources().getString(R.string.tab_title_ranking));
        mTitles.add(getResources().getString(R.string.tab_title_strategy_store));
        mBaseFragmentPagerAdapter = new BaseFragmentPagerAdapter(getFragmentManager(), mFragments);
        mBaseFragmentPagerAdapter.setTitles(mTitles);
        mHomeViewPager.setAdapter(mBaseFragmentPagerAdapter);
        mHomeViewPager.setOffscreenPageLimit(3);
        mHomeTabLayout.setupWithViewPager(mHomeViewPager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBind.unbind();
    }
}
