package com.hackhome.legendassistant.presenter.contract;

import com.hackhome.legendassistant.bean.BaseBean;
import com.hackhome.legendassistant.bean.HomeResultBean;
import com.hackhome.legendassistant.ui.base.BaseView;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
public interface RecommendContract {

    interface IRecommendModel{
        Observable<BaseBean<HomeResultBean>> getRecommendResult(String param);
    }

    interface IRecommendView extends BaseView{
        void showHomeResultBean(HomeResultBean homeResultBean);
    }

}
