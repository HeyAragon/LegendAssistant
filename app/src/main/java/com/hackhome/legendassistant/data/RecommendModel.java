package com.hackhome.legendassistant.data;

import com.hackhome.legendassistant.bean.BaseBean;
import com.hackhome.legendassistant.bean.HomeResultBean;
import com.hackhome.legendassistant.presenter.contract.RecommendContract;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
public class RecommendModel implements RecommendContract.IRecommendModel {

    private ApiService mApiService;

    public RecommendModel(ApiService apiService) {
        mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<HomeResultBean>> getRecommendResult(String param) {
        return mApiService.getRecommendResult(param);
    }

}
