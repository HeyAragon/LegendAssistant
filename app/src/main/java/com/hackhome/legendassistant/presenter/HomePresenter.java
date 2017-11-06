package com.hackhome.legendassistant.presenter;


import android.widget.Toast;

import com.hackhome.legendassistant.bean.BaseResultBean;
import com.hackhome.legendassistant.common.rx.RxHttpResponseCompat;
import com.hackhome.legendassistant.common.rx.subscriber.ProgressSubscriber;
import com.hackhome.legendassistant.presenter.contract.HomeContract;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

/**
 * Created by Administrator on 2017/9/19 0019.
 */
public class HomePresenter extends BasePresenter<HomeContract.IHomeModel,HomeContract.IHomeView> {

    private static final String TAG = "HomePresenter";
    
    @Inject
    public HomePresenter(HomeContract.IHomeView homeView, HomeContract.IHomeModel homeModel) {
        super(homeModel, homeView);
    }

    public void getHomeResult(String param) {

        mModel.getHomeResult(param)
                .compose(RxHttpResponseCompat.transfomResult())
                .subscribe(new ProgressSubscriber<BaseResultBean>(mContext, mView) {
                    @Override
                    public void onNext(@NonNull BaseResultBean baseResultBean) {
                        mView.showHomeResult(baseResultBean);
                        Toast.makeText(mContext, "success", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
