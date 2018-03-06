package com.wks.daggertutorial.ui.examples.example1.view;

import com.wks.daggertutorial.dependencies.PerFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by waqqassheikh on 28/02/2018.
 */

@PerFragment
@Subcomponent(modules = Example1FragmentModule.class)
public interface Example1FragmentSubcomponent extends AndroidInjector<Example1Fragment>{

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<Example1Fragment> {
    }
}
