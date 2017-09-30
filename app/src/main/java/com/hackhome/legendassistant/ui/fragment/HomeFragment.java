package com.hackhome.legendassistant.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hackhome.legendassistant.R;
import com.hackhome.legendassistant.bean.HomeResultBean;
import com.hackhome.legendassistant.dagger.component.AppComponent;
import com.hackhome.legendassistant.dagger.component.DaggerHomeComponent;
import com.hackhome.legendassistant.dagger.module.HomeModule;
import com.hackhome.legendassistant.presenter.HomePresenter;
import com.hackhome.legendassistant.presenter.contract.HomeContract;
import com.hackhome.legendassistant.ui.adapter.HomeFragmentPagerAdapter;
import com.hackhome.legendassistant.ui.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;



public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.IHomeView {

//    @BindView(R.id.home_tab_recommend)
//    TabItem mHomeTabRecommend;
//    @BindView(R.id.home_tab_list)
//    TabItem mHomeTabList;
//    @BindView(R.id.home_tab_strategy)
//    TabItem mHomeTabStrategy;


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
    private HomeFragmentPagerAdapter mHomeFragmentPagerAdapter;

    public static HomeFragment newInstance() {
        HomeFragment homeFragment = new HomeFragment();
        return homeFragment;
    }

    @Override
    protected int setLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        initFragment();
        initPagerAdapter();
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
        mHomeFragmentPagerAdapter = new HomeFragmentPagerAdapter(getFragmentManager(), mFragments);
        mHomeViewPager.setAdapter(mHomeFragmentPagerAdapter);
        mHomeTabLayout.setupWithViewPager(mHomeViewPager);
    }
    @Override
    protected void setAppComponent(AppComponent appComponent) {
//        DaggerHomeComponent.builder()
//                .appComponent(appComponent)
//                .homeModule(new HomeModule(this))
//                .build()
//                .inject(this);
    }

    @Override
    public void showHomeResult(HomeResultBean homeResultBean) {

    }

}
