package com.hackhome.legendassistant.presenter.contract;

import com.hackhome.legendassistant.bean.BaseBean;
import com.hackhome.legendassistant.bean.BaseResultBean;
import com.hackhome.legendassistant.bean.DataBean;
import com.hackhome.legendassistant.ui.base.BaseView;

import io.reactivex.Observable;

/**
 * 首页--排行榜--contract
 * Created by Administrator on 2017/10/17 0017.
 */
public interface GameInfoContract {

    /**
     * 首页--排行榜--Model
     */
    interface IGameInfoModel{
        Observable<BaseBean<BaseResultBean>> getGameInfoResult(String param);
    }

    /**
     * 首页--排行榜--view
     */
    interface IGameInfoView extends BaseView {
        void showGameInfoResult(BaseResultBean bean);
    }
}
