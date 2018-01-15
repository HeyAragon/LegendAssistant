package com.hackhome.legendassistant.common.rx.subscriber;

import android.content.Context;

import com.hackhome.legendassistant.common.exception.BaseException;
import com.hackhome.legendassistant.common.rx.RxErrorHandler;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/9/27 0027.
 */
public abstract class ErrorHandleSubscriber<T> extends BaseSubscriber<T> {

    protected RxErrorHandler mRxErrorHandler;

    protected Context mContext;

    public ErrorHandleSubscriber(Context context) {

        this.mContext = context;

        mRxErrorHandler = new RxErrorHandler(mContext);
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onError(@NonNull Throwable e) {
        BaseException baseException = mRxErrorHandler.handleError(e);

        if (null == baseException) {
            e.printStackTrace();
        } else {
            mRxErrorHandler.showErrorMessage(baseException);

        }

    }
}
