package com.hackhome.legendassistant.dagger.component;

import com.hackhome.legendassistant.dagger.FragmentScope;
import com.hackhome.legendassistant.dagger.module.AppModule;
import com.hackhome.legendassistant.dagger.module.RecommendModule;
import com.hackhome.legendassistant.ui.fragment.RecommendFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
@FragmentScope
@Component(modules = RecommendModule.class,dependencies = AppComponent.class)
public interface RecommendComponent {

    void inject(RecommendFragment recommendFragment);

}
