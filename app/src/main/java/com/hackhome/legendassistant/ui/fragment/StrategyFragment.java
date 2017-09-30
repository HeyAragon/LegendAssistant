package com.hackhome.legendassistant.ui.fragment;

import com.hackhome.legendassistant.R;
import com.hackhome.legendassistant.bean.HomeResultBean;
import com.hackhome.legendassistant.dagger.component.AppComponent;
import com.hackhome.legendassistant.presenter.RecommendPresenter;
import com.hackhome.legendassistant.presenter.contract.RecommendContract;
import com.hackhome.legendassistant.ui.base.BaseFragment;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
public class StrategyFragment extends BaseFragment<RecommendPresenter> implements RecommendContract.IRecommendView{

    public static StrategyFragment newInstance() {
        return new StrategyFragment();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setAppComponent(AppComponent appComponent) {

    }

    @Override
    protected int setLayoutRes() {
        return R.layout.fragment_strategy;
    }

    @Override
    public void showHomeResultBean(HomeResultBean homeResultBean) {

    }
}
