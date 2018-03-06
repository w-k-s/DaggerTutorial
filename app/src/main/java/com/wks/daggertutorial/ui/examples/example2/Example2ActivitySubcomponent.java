package com.wks.daggertutorial.ui.examples.example2;

import com.wks.daggertutorial.dependencies.PerActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by waqqassheikh on 28/02/2018.
 */
@PerActivity
@Subcomponent(modules = Example2ActivityModule.class)
public interface Example2ActivitySubcomponent extends AndroidInjector<Example2Activity>{

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<Example2Activity>{}
}
