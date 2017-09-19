package com.hackhome.legendassistant.dagger.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/9/18 0018.
 */
@Module
public class AppModule {

    private Application mApplication;


    public AppModule(Application application){

        this.mApplication = application;

    }

    @Provides
    @Singleton
    public Application provideApplication(){

        return  mApplication;
    }

}
