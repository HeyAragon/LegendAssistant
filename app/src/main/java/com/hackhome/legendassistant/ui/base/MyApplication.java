package com.hackhome.legendassistant.ui.base;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.hackhome.legendassistant.common.fresco.ImageLoaderConfig;
import com.hackhome.legendassistant.dagger.component.AppComponent;
import com.hackhome.legendassistant.dagger.component.DaggerAppComponent;
import com.hackhome.legendassistant.dagger.module.AppModule;
import com.hackhome.legendassistant.dagger.module.HttpModule;
import com.liulishuo.filedownloader.FileDownloader;

/**
 * Created by Aragon on 2017/9/13 0013.
 */
public class MyApplication extends Application {

    private AppComponent mAppComponent;

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public static MyApplication get(Context context) {
        return (MyApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ImagePipelineConfig imagePipelineConfig = ImageLoaderConfig.getInstance(getApplicationContext()).getImagePipelineConfig();
        Fresco.initialize(getApplicationContext(),imagePipelineConfig);
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).httpModule(new HttpModule()).build();
        FileDownloader.setup(this);
    }
}

