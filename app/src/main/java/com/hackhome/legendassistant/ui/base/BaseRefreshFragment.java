package com.hackhome.legendassistant.ui.base;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hackhome.legendassistant.R;
import com.hackhome.legendassistant.presenter.BasePresenter;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import javax.inject.Inject;

import butterknife.BindView;


/**
 * Created by Administrator on 2017/10/19 0019.
 */
public abstract class BaseRefreshFragment<T extends BasePresenter> extends BaseFragment {

    @BindView(R.id.base_recycler_view)
    RecyclerView mBaseRecyclerView;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout mBaseRefreshLayout;

    public BaseQuickAdapter mBaseQuickAdapter;

    public LayoutInflater mInflater;

    @Inject
    public T mPresenter;

    @Override

    protected void initData() {
        mInflater = LayoutInflater.from(mContext);
        mBaseQuickAdapter = buildAdapter();
        initRecyclerView();
        initView();
    }

    private void initRecyclerView() {

        mBaseRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mBaseRecyclerView.setAdapter(mBaseQuickAdapter);
    }

    @Override
    protected int setLayoutRes() {
        return R.layout.base_refresh_layout;
    }

    @Override
    public void initListener() {
        mBaseRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                onRefreshDada();
            }
        });

        if (mBaseQuickAdapter != null) {
            mBaseQuickAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
                @Override
                public void onLoadMoreRequested() {
                    onLoadMoreData();
                }
            }, mBaseRecyclerView);
        }
    }

    public RecyclerView getBaseRecyclerView() {
        return mBaseRecyclerView;
    }

    public SmartRefreshLayout getBaseRefreshLayout() {
        return mBaseRefreshLayout;
    }

    protected abstract void initView();

    protected abstract void onRefreshDada();

    protected abstract void onLoadMoreData();

    public abstract BaseQuickAdapter buildAdapter();

}
