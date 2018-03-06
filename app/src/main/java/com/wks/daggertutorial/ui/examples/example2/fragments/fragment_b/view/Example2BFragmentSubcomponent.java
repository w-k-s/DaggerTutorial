package com.wks.daggertutorial.ui.examples.example2.fragments.fragment_b.view;

import com.wks.daggertutorial.dependencies.PerFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by waqqassheikh on 28/02/2018.
 */
@PerFragment
@Subcomponent(modules = Example2BFragmentModule.class)
public interface Example2BFragmentSubcomponent extends AndroidInjector<Example2BFragment>{
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<Example2BFragment> {
    }
}
