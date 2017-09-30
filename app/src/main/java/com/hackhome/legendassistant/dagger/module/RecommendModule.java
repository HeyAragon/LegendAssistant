package com.hackhome.legendassistant.dagger.module;

import com.hackhome.legendassistant.data.ApiService;
import com.hackhome.legendassistant.data.RecommendModel;
import com.hackhome.legendassistant.presenter.contract.RecommendContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
@Module
public class RecommendModule {

    private RecommendContract.IRecommendView mView;

    public RecommendModule(RecommendContract.IRecommendView view) {
        mView = view;
    }

    @Provides
    public RecommendContract.IRecommendView provideRecommendView() {
        return mView;
    }

    @Provides
    public RecommendContract.IRecommendModel provideRecommendModel(ApiService apiService){
        return new RecommendModel(apiService);
    }
}
