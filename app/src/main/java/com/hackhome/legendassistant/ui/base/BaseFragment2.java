package com.hackhome.legendassistant.ui.base;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.nukc.stateview.StateView;
import com.hackhome.legendassistant.R;
import com.hackhome.legendassistant.dagger.component.AppComponent;

import java.lang.ref.WeakReference;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by aragon on 2017/10/20 0020.
 */
public abstract class BaseFragment2 extends LazyLoadFragment implements BaseView{
    protected WeakReference<View> mRootView;

    private Unbinder mBind;
    protected Context mContext;
    protected StateView mStateView;
    public MyApplication mApplication;
    private AnimationDrawable mDrawable;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            View view = inflater.inflate(getLayoutRes(), container, false);
            mRootView = new WeakReference<>(view);
            mBind = ButterKnife.bind(this, mRootView.get());
            mStateView = StateView.inject(mRootView.get());
            if (mStateView != null) {
                mStateView.setLoadingResource(R.layout.loading_layout);
                mStateView.setEmptyResource(R.layout.empty_layout);
                mStateView.setRetryResource(R.layout.error_layout);
            }

        } else {
            ViewGroup parent = (ViewGroup) mRootView.get().getParent();
            if (parent != null) {
                parent.removeView(mRootView.get());
            }
        }

        this.mApplication = (MyApplication) mContext.getApplicationContext();
        setAppComponent(mApplication.getAppComponent());

        return mRootView.get();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        initListener();
    }

    @Override
    public void showLoading() {
        if (isFirstEnter) {
            View loadingView = mStateView.showLoading();
            ImageView loadingImg= loadingView.findViewById(R.id.base_loading_img);
            loadingImg.setImageResource(R.drawable.loading_animation);
            mDrawable = (AnimationDrawable) loadingImg.getDrawable();
            mDrawable.start();
        }


    }

    @Override
    public void dismissLoading() {
        mStateView.showContent();
    }

    @Override
    public void showError(String error) {
        mStateView.showRetry();
        mStateView.setOnRetryClickListener(() -> {
            loadData();
            mStateView.showLoading();
            if (mDrawable != null) mDrawable.start();

        });
    }

    @Override
    protected void onFragmentFirstVisible() {
        //第一次可见时，加载网络数据
        loadData();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        WeakReference<Context> reference = new WeakReference<>(context);
        this.mContext = reference.get();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mBind != Unbinder.EMPTY) {
            mBind.unbind();
        }
    }

    /**
     * 设置资源文件
     * @return
     */
    @LayoutRes
    protected abstract int getLayoutRes();

    /**
     * 加载数据
     */
    protected void loadData() {

    }

    /**
     * 初始化数据
     */
    protected void initData() {

    }

    /**
     * 设置监听
     */
    protected void initListener() {

    }

    /**
     * 配置Dagger
     */
    protected void setAppComponent(AppComponent component) {

    }



}
