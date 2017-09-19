package com.hackhome.legendassistant.presenter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.hackhome.legendassistant.ui.base.BaseView;

/**
 * Created by Administrator on 2017/9/19 0019.
 */
public class BasePresenter<M, V extends BaseView> {

    protected M mModel;

    protected V mView;

    protected Context mContext;

    public BasePresenter(M m, V v) {
        this.mModel = m;
        this.mView = v;

    }

    private void initContext(){

        if(mView instanceof Fragment){
            mContext = ((Fragment)mView).getActivity();
        }
        else {
            mContext = (Activity) mView;
        }
    }

}
