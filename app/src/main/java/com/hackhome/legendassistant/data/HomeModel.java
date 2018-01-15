package com.hackhome.legendassistant.data;


import com.hackhome.legendassistant.bean.BaseBean;
import com.hackhome.legendassistant.bean.BaseResultBean;
import com.hackhome.legendassistant.presenter.contract.HomeContract;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/9/19 0019.
 */
public class HomeModel implements HomeContract.IHomeModel{

    private ApiService mApiService;

    public HomeModel(ApiService apiService) {
        mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<BaseResultBean>> getHomeResult(String params) {
        return mApiService.getHomeResult(params);
    }

}
