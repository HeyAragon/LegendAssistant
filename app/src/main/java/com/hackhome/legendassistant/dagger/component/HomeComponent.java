package com.hackhome.legendassistant.dagger.component;

import com.hackhome.legendassistant.dagger.FragmentScope;
import com.hackhome.legendassistant.dagger.module.HomeModule;
import com.hackhome.legendassistant.ui.fragment.HomeFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/9/20 0020.
 */
@FragmentScope
@Component(modules = HomeModule.class, dependencies = AppComponent.class)
public interface HomeComponent {

    void inject(HomeFragment homeFragment);

}
