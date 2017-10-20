package com.hackhome.legendassistant.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hackhome.legendassistant.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RankingList2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RankingList2Fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    @BindView(R.id.ranking_tab_layout)
    TabLayout mRankingTabLayout;
    @BindView(R.id.ranking_pager)
    ViewPager mRankingPager;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Unbinder mBind;


    public RankingList2Fragment() {
        // Required empty public constructor
    }


    public static RankingList2Fragment newInstance(String param1, String param2) {
        RankingList2Fragment fragment = new RankingList2Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ranking_list, container, false);
        mBind = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
//        mRankingPager.setAdapter(new);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBind.unbind();
    }
}
