package com.hackhome.legendassistant.dagger.module;

import com.hackhome.legendassistant.data.ApiService;
import com.hackhome.legendassistant.data.HomeModel;
import com.hackhome.legendassistant.presenter.contract.HomeContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/9/19 0019.
 */
@Module
public class HomeModule {

    private HomeContract.IHomeView mView;

    public HomeModule(HomeContract.IHomeView view) {
        mView = view;
    }

    @Provides
    public HomeContract.IHomeView provideHomeView() {
        return mView;
    }

    @Provides
    public HomeContract.IHomeModel provideHomeModel(ApiService apiService) {
        return new HomeModel(apiService);
    }
}
