package com.hackhome.legendassistant.ui.fragment;

import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hackhome.legendassistant.R;
import com.hackhome.legendassistant.bean.BaseResultBean;
import com.hackhome.legendassistant.dagger.component.AppComponent;
import com.hackhome.legendassistant.dagger.component.DaggerGameInfoComponent;
import com.hackhome.legendassistant.dagger.module.GameInfoModule;
import com.hackhome.legendassistant.presenter.GameInfoPresenter;
import com.hackhome.legendassistant.presenter.contract.GameInfoContract;
import com.hackhome.legendassistant.ui.adapter.BaseGameInfoAdapter;
import com.hackhome.legendassistant.ui.base.BaseRefreshFragment;


/**
 * Created by Administrator on 2017/10/18 0018.
 */
public class GameInfoFragment extends BaseRefreshFragment<GameInfoPresenter> implements GameInfoContract.IGameInfoView {

    private RecyclerView mGameInfoRecyclerView;
    private BaseGameInfoAdapter mBaseGameInfoAdapter;

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
        mBaseGameInfoAdapter = BaseGameInfoAdapter.builder()
                .itemResId(R.layout.base_game_info_item)
                .apiType(apiType)
                .build();
        return mBaseGameInfoAdapter;
    }

    @Override
    public void showGameInfoResult(BaseResultBean bean) {
        mBaseGameInfoAdapter.addData(bean.getData());
        Toast.makeText(mContext,"SUCCESS-RANKING",Toast.LENGTH_SHORT).show();
    }

}
