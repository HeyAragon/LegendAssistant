package com.hackhome.legendassistant.ui.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hackhome.legendassistant.dagger.component.AppComponent;
import com.hackhome.legendassistant.presenter.BasePresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/13 0013.
 */
public abstract class BaseFragment<T extends BasePresenter> extends Fragment {

    private View mRootView;

    protected MyApplication mApplication;

    @Inject
    T mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(setLayoutRes(), container, false);
        ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.mApplication = (MyApplication) getActivity().getApplication();
        setAppComponent(mApplication.getAppComponent());
        initData();
    }

    @LayoutRes
    protected abstract int setLayoutRes();

    protected abstract void initData();

    protected abstract void setAppComponent(AppComponent appComponent);


}
