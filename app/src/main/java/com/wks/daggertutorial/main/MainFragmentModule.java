package com.wks.daggertutorial.main;

import android.app.Fragment;

import com.wks.daggertutorial.base.BaseFragmentModule;
import com.wks.daggertutorial.dependencies.PerFragment;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;

import static com.wks.daggertutorial.base.BaseFragmentModule.FRAGMENT;

/**
 * The MainFragmentModule INCLUDES the BaseFragmentModule and PROVIDES a concrete fragment, in this case the MainFragment, as per the contract specified in BaseFragmentModule.
 */
@Module(includes = BaseFragmentModule.class)
public abstract class MainFragmentModule {


    @Binds
    @PerFragment
    @Named(FRAGMENT)
    public abstract Fragment fragment(MainFragment mainFragment);
}
