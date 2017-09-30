package com.hackhome.legendassistant.ui.base;

/**
 * Created by Administrator on 2017/9/19 0019.
 */
public interface BaseView {

    /**
     * 正在加载
     */
    void showLoading();

    /**
     * 加载结束
     */
    void dismissLoading();

    /**
     * 加载错误
     */
    void showError(String error);


}
