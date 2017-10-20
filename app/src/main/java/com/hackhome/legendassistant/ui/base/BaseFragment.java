package com.hackhome.legendassistant.ui.base;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.hackhome.legendassistant.R;
import com.hackhome.legendassistant.dagger.component.AppComponent;

import java.lang.ref.WeakReference;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/9/13 0013.
 */
public abstract class BaseFragment extends LazyLoadFragment implements BaseView{

    private static final String TAG = "BaseFragment";

    private FrameLayout mBaseRootView;

    private View mLoadingView;

    private View mEmptyView;

    private FrameLayout mRealViewContainer;

    protected View mRealViewContent;

    private TextView mErrorTxt;

    private ImageView mLoadingImg;

    protected MyApplication mApplication;

    private Unbinder mBinder;

    public Context mContext;

    private AnimationDrawable mAnimationDrawable;

    public boolean mIsFirstLoading = true;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBaseRootView = (FrameLayout) inflater.inflate(R.layout.fragment_base, container, false);
        this.mApplication = (MyApplication) getActivity().getApplication();
        setAppComponent(mApplication.getAppComponent());
        initBaseView();
        Log.i("aragon", "BaseFragment--onCreateView: ");
        return mBaseRootView;
    }

     private void initBaseView() {
         mLoadingView = mBaseRootView.findViewById(R.id.base_progress_view);

         mRealViewContainer =  mBaseRootView.findViewById(R.id.base_real_view_container);

         mErrorTxt = mBaseRootView.findViewById(R.id.base_error_tip_txt);

         mEmptyView = mBaseRootView.findViewById(R.id.base_empty_view);

         mLoadingImg = mBaseRootView.findViewById(R.id.base_loading_img);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("aragon", "BaseFragment--onActivityCreated: ");
        setRealContentView();
        initData();
        initListener();
    }

    private void setRealContentView() {
        mRealViewContent = LayoutInflater.from(mContext).inflate(setLayoutRes(),mRealViewContainer,false);
        mBinder = ButterKnife.bind(this,mRealViewContent);

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

    /**
     * dagger设置component
     * @param appComponent
     */
    protected void setAppComponent(AppComponent appComponent){}

    /**
     * 设置监听
     */
    public void initListener() {}

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 加载数据
     */
    protected abstract void loadData();

    /**
     * 加载布局资源文件
     * @return
     */
    @LayoutRes
    protected abstract int setLayoutRes();

    /**
     * 显示加载布局
     */
    @Override
    public void showLoading() {

        if (isFirstEnter) {
            //显示正在加载
            showView(R.id.base_progress_view);
            mLoadingImg.setImageResource(R.drawable.loading_animation);
            mAnimationDrawable = (AnimationDrawable) mLoadingImg.getDrawable();
            mAnimationDrawable.start();
        }

    }

    /**
     * 加载结束，显示 real view
     */
    @Override
    public void dismissLoading() {
        //显示正常内容
        showView(R.id.base_real_view_container);
        if (null != mAnimationDrawable) mAnimationDrawable.stop();

    }

    /**
     * 加载出错，显示错误布局
     * @param error
     */
    @Override
    public void showError(String error) {
        //显示错误提示
        showView(R.id.base_empty_view);
        mErrorTxt.setText(error);
        if (null != mAnimationDrawable) mAnimationDrawable.stop();
    }

    @Override
    protected void onFragmentFirstVisible() {
        //当fragment第一次可见时，加载数据
        Log.i("aragon", "BaseFragment--onFragmentFirstVisible: ");
        loadData();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        WeakReference<Context> reference = new WeakReference<Context>(context);
        mContext = reference.get();
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        if (mBinder!=Unbinder.EMPTY) {
//            mBinder.unbind();
//        }
    }
}
