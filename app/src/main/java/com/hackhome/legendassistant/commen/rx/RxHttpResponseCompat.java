package com.hackhome.legendassistant.commen.rx;

import com.hackhome.legendassistant.bean.BaseBean;
import com.hackhome.legendassistant.commen.exception.ApiException;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/9/19 0019.
 */
public class RxHttpResponseCompat {

    public static <T> ObservableTransformer<BaseBean<T>,T> transfomResult(){

        return new ObservableTransformer<BaseBean<T>, T>() {
            @Override
            public ObservableSource<T> apply(@NonNull Observable<BaseBean<T>> baseBeanObservable) {
                return baseBeanObservable.flatMap(new Function<BaseBean<T>, ObservableSource<T>>() {
                    @Override
                    public ObservableSource<T> apply(@NonNull final BaseBean<T> tBaseBean) throws Exception {

                        if (tBaseBean.success()) {
                            return Observable.create(new ObservableOnSubscribe<T>() {
                                @Override
                                public void subscribe(@NonNull ObservableEmitter<T> subscriber) throws Exception {
                                    try {
                                        subscriber.onNext(tBaseBean.getResult());
                                        subscriber.onComplete();
                                    } catch (Exception e) {
                                        subscriber.onError(e);
                                    }

                                }
                            });
                        } else {
                            return Observable.error(new ApiException(tBaseBean.getCode(),tBaseBean.getMessage()));
                        }
                    }
                });
            }
        };
    }

}
