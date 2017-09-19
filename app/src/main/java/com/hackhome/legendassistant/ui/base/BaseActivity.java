package com.hackhome.legendassistant.ui.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/13 0013.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutRes());
        ButterKnife.bind(this);

        initView();
        initData();
        initListener();
    }


    @LayoutRes
    protected abstract int setLayoutRes();


    public void initView() {
    }
    public void initData() {
    }
    public void initListener() {
    }
}
