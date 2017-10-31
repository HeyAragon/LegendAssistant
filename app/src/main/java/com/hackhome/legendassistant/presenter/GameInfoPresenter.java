package com.hackhome.legendassistant.presenter;

import com.hackhome.legendassistant.bean.BaseResultBean;
import com.hackhome.legendassistant.bean.DataBean;
import com.hackhome.legendassistant.commen.rx.RxHttpResponseCompat;
import com.hackhome.legendassistant.commen.rx.subscriber.ProgressSubscriber;
import com.hackhome.legendassistant.presenter.contract.GameInfoContract;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

/**
 * Created by Administrator on 2017/10/17 0017.
 */
public class GameInfoPresenter extends BasePresenter<GameInfoContract.IGameInfoModel, GameInfoContract.IGameInfoView> {

    private String commonParam = "ranktop-home-140-type-";

    @Inject
    public GameInfoPresenter(GameInfoContract.IGameInfoModel gameInfoModel, GameInfoContract.IGameInfoView gameInfoView) {
        super(gameInfoModel, gameInfoView);
    }

    public void getGameInfoResult(String type) {
        mModel.getGameInfoResult(commonParam + type)
                .compose(RxHttpResponseCompat.transfomResult())
                .subscribe(new ProgressSubscriber<BaseResultBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull BaseResultBean bean) {
                        mView.showGameInfoResult(bean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        super.onError(e);
                    }
                });
    }
}
