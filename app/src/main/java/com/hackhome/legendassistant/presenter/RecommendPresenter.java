package com.hackhome.legendassistant.presenter;

import com.hackhome.legendassistant.bean.HomeResultBean;
import com.hackhome.legendassistant.commen.rx.RxHttpResponseCompat;
import com.hackhome.legendassistant.commen.rx.subscriber.ProgressSubscriber;
import com.hackhome.legendassistant.presenter.contract.RecommendContract;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.annotations.NonNull;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
public class RecommendPresenter extends BasePresenter<RecommendContract.IRecommendModel,RecommendContract.IRecommendView> {

    @Inject
    public RecommendPresenter(RecommendContract.IRecommendModel iRecommendModel, RecommendContract.IRecommendView iRecommendView) {
        super(iRecommendModel, iRecommendView);
    }

    public void getRecommendResult(String param) {
        mModel.getRecommendResult(param)
                .compose(RxHttpResponseCompat.transfomResult())
                .subscribe(new ProgressSubscriber<HomeResultBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull HomeResultBean homeResultBean) {
                        mView.showHomeResultBean(homeResultBean);
                    }
                });

    }
}
