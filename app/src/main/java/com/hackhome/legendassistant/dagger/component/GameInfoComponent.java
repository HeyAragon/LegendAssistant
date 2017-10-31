package com.hackhome.legendassistant.dagger.component;

import com.hackhome.legendassistant.dagger.FragmentScope;
import com.hackhome.legendassistant.dagger.module.GameInfoModule;
import com.hackhome.legendassistant.ui.fragment.GameInfoFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/10/17 0017.
 */
@FragmentScope
@Component(modules = GameInfoModule.class,dependencies = AppComponent.class)
public interface GameInfoComponent {
    void inject(GameInfoFragment gameInfoFragment);
}
