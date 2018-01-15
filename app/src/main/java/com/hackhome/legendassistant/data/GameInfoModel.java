package com.hackhome.legendassistant.data;

import com.hackhome.legendassistant.bean.BaseBean;
import com.hackhome.legendassistant.bean.BaseResultBean;
import com.hackhome.legendassistant.bean.DataBean;
import com.hackhome.legendassistant.presenter.contract.GameInfoContract;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/10/17 0017.
 */
public class GameInfoModel implements GameInfoContract.IGameInfoModel {

    private ApiService mApiService;

    public GameInfoModel(ApiService apiService) {
        mApiService = apiService;
    }

    @Override
    public Observable<BaseBean<BaseResultBean>> getGameInfoResult(String param) {
        return mApiService.getGameInfoResult(param);
    }
}
