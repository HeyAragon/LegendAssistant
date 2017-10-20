package com.hackhome.legendassistant.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.hackhome.legendassistant.R;
import com.hackhome.legendassistant.ui.adapter.BaseFragmentPagerAdapter;
import com.hackhome.legendassistant.ui.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
public class RankingListFragment extends BaseFragment {

    public static final String TYPE_NEW = "sugar";
    public static final String TYPE_HOT = "hot";
    public static final String TYPE_EXPECT = "expect";

    private ArrayList<Fragment> mFragments;
    private ArrayList<String> mTitles;


    @BindView(R.id.ranking_tab_layout)
    TabLayout mRankingTabLayout;
    @BindView(R.id.ranking_pager)
    ViewPager mRankingPager;

    private BaseFragmentPagerAdapter mBaseFragmentPagerAdapter;


    public static RankingListFragment newInstance() {
        Bundle args = new Bundle();
        RankingListFragment fragment = new RankingListFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void initData() {
        mFragments = new ArrayList<>();
        mTitles = new ArrayList<>();
        mFragments.add(new GameInfoFragment(TYPE_NEW));
        mFragments.add(new GameInfoFragment(TYPE_HOT));
        mFragments.add(new GameInfoFragment(TYPE_EXPECT));
        mTitles.add(getResources().getString(R.string.tab_title_new_rise));
        mTitles.add(getResources().getString(R.string.tab_title_popular));
        mTitles.add(getResources().getString(R.string.tab_title_expect));
        mBaseFragmentPagerAdapter = new BaseFragmentPagerAdapter(getFragmentManager(),mFragments);
        mBaseFragmentPagerAdapter.setTitles(mTitles);
        mRankingPager.setAdapter(mBaseFragmentPagerAdapter);
        mRankingTabLayout.setupWithViewPager(mRankingPager);
    }

    @Override
    protected void loadData() {
        //load data
    }


    @Override
    protected int setLayoutRes() {
        return R.layout.fragment_ranking_list;
    }

}
