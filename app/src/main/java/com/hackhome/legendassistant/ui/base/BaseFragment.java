package com.hackhome.legendassistant.ui.base;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.hackhome.legendassistant.R;
import com.hackhome.legendassistant.dagger.component.AppComponent;
import com.hackhome.legendassistant.presenter.BasePresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/9/13 0013.
 */
public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView{

    private FrameLayout mBaseRootView;

    private View mLoadingView;

    private View mEmptyView;

    private FrameLayout mRealViewContent;

    private TextView mErrorTxt;

    private ImageView mLoadingImg;

    protected MyApplication mApplication;

    private Unbinder mBinder;

    private AnimationDrawable mAnimationDrawable;

    @Inject
    public T mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBaseRootView = (FrameLayout) inflater.inflate(R.layout.fragment_base, container, false);
        initBaseView();

        return mBaseRootView;
    }

     private void initBaseView() {
         mLoadingView = mBaseRootView.findViewById(R.id.base_progress_view);

         mRealViewContent =  mBaseRootView.findViewById(R.id.base_real_view_content);

         mErrorTxt = mBaseRootView.findViewById(R.id.base_error_tip_txt);

         mEmptyView = mBaseRootView.findViewById(R.id.base_empty_view);

         mLoadingImg = mBaseRootView.findViewById(R.id.base_loading_img);


    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.mApplication = (MyApplication) getActivity().getApplication();
        setAppComponent(mApplication.getAppComponent());
        setRealContentView();
        initData();
    }

    private void setRealContentView() {
        View realContentView = LayoutInflater.from(getActivity()).inflate(setLayoutRes(), mRealViewContent, true);
        mBinder = ButterKnife.bind(this, realContentView);

    }

    public void showView(@IdRes int viewId) {

        for (int i = 0; i < mBaseRootView.getChildCount(); i++) {
            int childId = mBaseRootView.getChildAt(i).getId();
            if (childId == viewId) {
                mBaseRootView.getChildAt(i).setVisibility(View.VISIBLE);
            } else {
                mBaseRootView.getChildAt(i).setVisibility(View.GONE);
            }
        }
    }

    protected abstract void initData();

    protected abstract void setAppComponent(AppComponent appComponent);


    @LayoutRes
    protected abstract int setLayoutRes();



    @Override
    public void showLoading() {
        //显示正在加载
        showView(R.id.base_progress_view);
        mLoadingImg.setImageResource(R.drawable.loading_animation);
        mAnimationDrawable = (AnimationDrawable) mLoadingImg.getDrawable();
        mAnimationDrawable.start();
    }

    @Override
    public void dismissLoading() {
        //显示正常内容
        showView(R.id.base_real_view_content);
        if (null != mAnimationDrawable) mAnimationDrawable.stop();

    }

    @Override
    public void showError(String error) {
        //显示错误提示
        showView(R.id.base_empty_view);
        mErrorTxt.setText(error);
        if (null != mAnimationDrawable) mAnimationDrawable.stop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mBinder!=Unbinder.EMPTY) {
//            mBinder.unbind();
        }
    }
}
