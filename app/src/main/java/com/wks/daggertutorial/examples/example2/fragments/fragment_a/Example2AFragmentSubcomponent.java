package com.wks.daggertutorial.examples.example2.fragments.fragment_a;

import com.wks.daggertutorial.dependencies.PerFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by waqqassheikh on 28/02/2018.
 */
@PerFragment
@Subcomponent(modules = Example2AFragmentModule.class)
public interface Example2AFragmentSubcomponent extends AndroidInjector<Example2AFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<Example2AFragment> {
    }
}
