package com.hackhome.legendassistant.commen.rx.subscriber;

import android.content.Context;

import com.hackhome.legendassistant.commen.exception.BaseException;
import com.hackhome.legendassistant.ui.base.BaseView;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/9/27 0027.
 */
public abstract class ProgressSubscriber<T> extends ErrorHandleSubscriber<T> {

    private BaseView mView;

    public ProgressSubscriber(Context context, BaseView view) {
        super(context);
        this.mView = view;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        mView.showLoading();
    }

    @Override
    public void onComplete() {
        mView.dismissLoading();
    }

    @Override
    public void onError(@NonNull Throwable e) {
        e.printStackTrace();
        BaseException baseException = mRxErrorHandler.handleError(e);
        mView.showError(baseException.getDisplayMessage());
    }
}
