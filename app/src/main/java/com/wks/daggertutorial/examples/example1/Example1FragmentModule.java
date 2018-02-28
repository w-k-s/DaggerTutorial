package com.wks.daggertutorial.examples.example1;

import android.app.Fragment;

import com.wks.daggertutorial.base.BaseFragmentModule;
import com.wks.daggertutorial.dependencies.PerFragment;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;

/**
 * Created by waqqassheikh on 28/02/2018.
 */

@Module(includes = BaseFragmentModule.class)
public abstract class Example1FragmentModule {

    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragment
    abstract Fragment fragment(Example1Fragment fragment);
}
