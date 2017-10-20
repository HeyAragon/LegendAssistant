package com.hackhome.legendassistant.ui.fragment;


import android.os.Bundle;

import com.hackhome.legendassistant.R;
import com.hackhome.legendassistant.dagger.component.AppComponent;
import com.hackhome.legendassistant.ui.base.BaseFragment;


public class CategoryFragment extends BaseFragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;


    public static CategoryFragment newInstance(String param1, String param2) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static CategoryFragment newInstance() {
        CategoryFragment homeFragment = new CategoryFragment();
        return homeFragment;
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
    protected int setLayoutRes() {
        return R.layout.fragment_category;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setAppComponent(AppComponent appComponent) {

    }

}
