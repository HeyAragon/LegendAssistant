package com.hackhome.legendassistant.ui.fragment;


import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hackhome.legendassistant.R;
import com.hackhome.legendassistant.ui.adapter.BaseFragmentPagerAdapter;
import com.socks.library.KLog;

import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.Manifest.permission_group.STORAGE;

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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (getContext().checkSelfPermission(STORAGE) != PackageManager.PERMISSION_GRANTED) {
                KLog.i("aragon","not_granted");
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 111);
            } else {
                KLog.i("aragon","granted");
            }

        }
    }
//
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 111) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                KLog.i("aragon", "granted");
            } else {
                KLog.i("aragon","permission denied");
            }
        }
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
