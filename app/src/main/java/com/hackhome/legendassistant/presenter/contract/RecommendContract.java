package com.hackhome.legendassistant.presenter.contract;

import com.hackhome.legendassistant.bean.BaseBean;
import com.hackhome.legendassistant.bean.BaseResultBean;
import com.hackhome.legendassistant.ui.base.BaseView;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
public interface RecommendContract {

    /**
     * 首页推荐Model
     */
    interface IRecommendModel{
        Observable<BaseBean<BaseResultBean>> getRecommendResult(String param);
    }

    interface IRecommendView extends BaseView{
        void showHomeResultBean(BaseResultBean baseResultBean, boolean isFromRefresh);

        void loadMoreComplete();
    }

}
