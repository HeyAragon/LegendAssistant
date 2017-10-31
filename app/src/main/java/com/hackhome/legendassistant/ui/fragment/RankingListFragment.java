package com.hackhome.legendassistant.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hackhome.legendassistant.R;
import com.hackhome.legendassistant.ui.adapter.BaseFragmentPagerAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RankingListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RankingListFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    @BindView(R.id.ranking_tab_layout)
    TabLayout mRankingTabLayout;
    @BindView(R.id.ranking_pager)
    ViewPager mRankingPager;

    public static final String TYPE_NEW = "sugar";
    public static final String TYPE_HOT = "hot";
    public static final String TYPE_EXPECT = "expect";

    private BaseFragmentPagerAdapter mBaseFragmentPagerAdapter;
    private ArrayList<Fragment> mFragments;
    private ArrayList<String> mTitles;
    private Unbinder mBind;


    public RankingListFragment() {
        // Required empty public constructor
    }


    public static RankingListFragment newInstance() {
        RankingListFragment fragment = new RankingListFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ranking_list, container, false);
        mBind = ButterKnife.bind(this,view);
        initView();
        return view;
    }

    private void initView() {
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
        mRankingPager.setOffscreenPageLimit(2);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBind.unbind();
    }
}
