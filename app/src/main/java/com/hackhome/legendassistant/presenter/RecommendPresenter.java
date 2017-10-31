package com.hackhome.legendassistant.presenter;

import com.hackhome.legendassistant.bean.BaseResultBean;
import com.hackhome.legendassistant.commen.rx.RxHttpResponseCompat;
import com.hackhome.legendassistant.commen.rx.subscriber.ErrorHandleSubscriber;
import com.hackhome.legendassistant.commen.rx.subscriber.ProgressSubscriber;
import com.hackhome.legendassistant.presenter.contract.RecommendContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
public class RecommendPresenter extends BasePresenter<RecommendContract.IRecommendModel,RecommendContract.IRecommendView> {

    private String params = "recommend-home-144-page-";

    @Inject
    public RecommendPresenter(RecommendContract.IRecommendModel iRecommendModel, RecommendContract.IRecommendView iRecommendView) {
        super(iRecommendModel, iRecommendView);
    }

    public void getRecommendResult(int page) {
//        mModel.getRecommendResult(params + page)
//                .compose(RxHttpResponseCompat.transfomResult())
//                .subscribe(new ProgressSubscriber<BaseResultBean>(mContext, mView) {
//                    @Override
//                    public void onNext(@NonNull BaseResultBean homeResultBean) {
//                        mView.showHomeResultBean(homeResultBean);
//                    }
//                });
        Observer subscriber = null;

        if (page == 1) {
            subscriber = new ProgressSubscriber<BaseResultBean>(mContext, mView) {
                @Override
                public void onNext(@NonNull BaseResultBean baseResultBean) {
                    mView.showHomeResultBean(baseResultBean,true);
                }
            };
        } else {
            subscriber = new ErrorHandleSubscriber<BaseResultBean>(mContext) {
                @Override
                public void onNext(@NonNull BaseResultBean baseResultBean) {
                    mView.showHomeResultBean(baseResultBean,false);
                }

                @Override
                public void onComplete() {
                    mView.loadMoreComplete();
                }
            };
        }

        mModel.getRecommendResult(params + page)
                .compose(RxHttpResponseCompat.transfomResult())
                .subscribe(subscriber);
    }
}
