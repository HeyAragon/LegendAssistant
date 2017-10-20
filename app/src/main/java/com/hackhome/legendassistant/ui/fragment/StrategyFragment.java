package com.hackhome.legendassistant.ui.fragment;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hackhome.legendassistant.bean.HomeResultBean;
import com.hackhome.legendassistant.dagger.component.AppComponent;
import com.hackhome.legendassistant.presenter.RecommendPresenter;
import com.hackhome.legendassistant.presenter.contract.RecommendContract;
import com.hackhome.legendassistant.ui.base.BaseRefreshFragment;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
public class StrategyFragment extends BaseRefreshFragment<RecommendPresenter> implements RecommendContract.IRecommendView{

    public static StrategyFragment newInstance() {
        return new StrategyFragment();
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void setAppComponent(AppComponent appComponent) {

    }


    @Override
    protected void initView() {

    }

    @Override
    public void onRefreshDada() {

    }

    @Override
    public void onLoadMoreData() {

    }

    @Override
    public BaseQuickAdapter buildAdapter() {
        return null;
    }


    @Override
    public void showHomeResultBean(HomeResultBean homeResultBean, boolean isFromRefresh) {

    }

    @Override
    public void loadMoreComplete() {

    }
}
