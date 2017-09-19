package com.hackhome.legendassistant.ui.fragment;


import android.os.Bundle;
import com.hackhome.legendassistant.R;
import com.hackhome.legendassistant.dagger.component.AppComponent;
import com.hackhome.legendassistant.presenter.HomePresenter;
import com.hackhome.legendassistant.presenter.contract.HomeContract;
import com.hackhome.legendassistant.ui.base.BaseFragment;


public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.IHomeView{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static HomeFragment newInstance() {
        HomeFragment homeFragment = new HomeFragment();
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
        return R.layout.fragment_hot;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setAppComponent(AppComponent appComponent) {

    }


    @Override
    public void showData() {

    }
}
