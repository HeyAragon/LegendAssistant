package com.hackhome.legendassistant.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hackhome.legendassistant.R;
import com.hackhome.legendassistant.bean.HomeResultBean;
import com.hackhome.legendassistant.dagger.component.AppComponent;
import com.hackhome.legendassistant.dagger.component.DaggerGameInfoComponent;
import com.hackhome.legendassistant.dagger.module.GameInfoModule;
import com.hackhome.legendassistant.presenter.GameInfoPresenter;
import com.hackhome.legendassistant.presenter.contract.GameInfoContract;
import com.hackhome.legendassistant.ui.base.BaseRefreshFragment;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/10/18 0018.
 */
public class GameInfoFragment extends BaseRefreshFragment<GameInfoPresenter> implements GameInfoContract.IGameInfoView {

    private RecyclerView mGameInfoRecyclerView;

    private String apiType;

    public GameInfoFragment(String apiType) {
        this.apiType = apiType;
    }


    @Override
    protected void loadData() {
        mPresenter.getGameInfoResult(apiType);
    }

    @Override
    protected void setAppComponent(AppComponent appComponent) {
        DaggerGameInfoComponent.builder()
                .appComponent(appComponent)
                .gameInfoModule(new GameInfoModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected int setLayoutRes() {
        return R.layout.fragment_game_info;
    }

    @Override
    protected void initView() {
        mGameInfoRecyclerView = getBaseRecyclerView();
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
    public void showGameInfoResult(HomeResultBean bean) {
        Toast.makeText(getContext(),"SUCCESS-RANKING",Toast.LENGTH_SHORT).show();
    }

}
