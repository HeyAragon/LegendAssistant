package com.hackhome.legendassistant.dagger.module;

import com.hackhome.legendassistant.data.ApiService;
import com.hackhome.legendassistant.data.GameInfoModel;
import com.hackhome.legendassistant.presenter.contract.GameInfoContract;

import dagger.Module;
import dagger.Provides;

/**
 * 首页--P
 * Created by Administrator on 2017/9/29 0029.
 */
@Module
public class GameInfoModule {

    private GameInfoContract.IGameInfoView mView;

    public GameInfoModule(GameInfoContract.IGameInfoView view) {
        mView = view;
    }

    @Provides
    public GameInfoContract.IGameInfoView provideGameInfoView() {
        return mView;
    }

    @Provides
    public GameInfoContract.IGameInfoModel provideGameInfoModel(ApiService apiService){
        return new GameInfoModel(apiService);
    }
}
