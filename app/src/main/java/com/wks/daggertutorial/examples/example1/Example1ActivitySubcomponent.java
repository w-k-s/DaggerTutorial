package com.wks.daggertutorial.examples.example1;

import com.wks.daggertutorial.dependencies.PerActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by waqqassheikh on 28/02/2018.
 */
@PerActivity
@Subcomponent(modules = Example1ActivityModule.class)
public interface Example1ActivitySubcomponent extends AndroidInjector<Example1Activity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<Example1Activity> {
    }
}
