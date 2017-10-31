package com.hackhome.legendassistant.data;

import com.hackhome.legendassistant.bean.BaseBean;
import com.hackhome.legendassistant.bean.BaseResultBean;
import com.hackhome.legendassistant.presenter.contract.RecommendContract;

import io.reactivex.Observable;

/**
 * 首页--推荐--model
 * Created by Administrator on 2017/9/29 0029.
 */
public class RecommendModel implements RecommendContract.IRecommendModel{

    private ApiService mApiService;

    public RecommendModel(ApiService apiService) {
        mApiService = apiService;
    }

    /**
     * 获取首页推荐数据
     * @param param
     * @return
     */
    @Override
    public Observable<BaseBean<BaseResultBean>> getRecommendResult(String param) {
        return mApiService.getRecommendResult(param);
    }

}
