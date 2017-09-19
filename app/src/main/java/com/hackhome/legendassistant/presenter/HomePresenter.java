package com.hackhome.legendassistant.presenter;


import com.hackhome.legendassistant.bean.BaseBean;
import com.hackhome.legendassistant.bean.HomeResultBean;
import com.hackhome.legendassistant.commen.rx.RxHttpResponseCompat;
import com.hackhome.legendassistant.presenter.contract.HomeContract;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/9/19 0019.
 */
public class HomePresenter extends BasePresenter<HomeContract.IHomeModel,HomeContract.IHomeView> {

    @Inject
    public HomePresenter(HomeContract.IHomeView homeView, HomeContract.IHomeModel homeModel) {
        super(homeModel, homeView);
    }

    public void getHomeResult(String param) {
        mModel.getHomeResult(param)
                .compose(RxHttpResponseCompat.<HomeResultBean>transfomResult())
                .subscribe(new Observer<HomeResultBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull HomeResultBean homeResultBean) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
