package com.wks.daggertutorial.examples.example2.fragments.fragment_b;

import com.wks.daggertutorial.dependencies.PerFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by waqqassheikh on 28/02/2018.
 */
@PerFragment
@Subcomponent
public interface Example2BFragmentSubcomponent extends AndroidInjector.Factory<Example2BFragment>{
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<Example2BFragment> {
    }
}
