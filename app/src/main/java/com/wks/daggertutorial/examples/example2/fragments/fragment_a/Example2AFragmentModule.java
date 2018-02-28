package com.wks.daggertutorial.examples.example2.fragments.fragment_a;

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
public abstract class Example2AFragmentModule {

    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragment
    abstract Fragment fragment(Example2AFragment example2AFragment);
}
