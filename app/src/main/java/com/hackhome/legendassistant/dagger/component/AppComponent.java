package com.hackhome.legendassistant.dagger.component;

import android.app.Application;

import com.hackhome.legendassistant.dagger.module.AppModule;
import com.hackhome.legendassistant.dagger.module.HttpModule;
import com.hackhome.legendassistant.data.ApiService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2017/9/18 0018.
 */

@Singleton
@Component(modules = {HttpModule.class, AppModule.class})
public interface AppComponent {

    ApiService getApiservice();

    Application getApplication();


}
