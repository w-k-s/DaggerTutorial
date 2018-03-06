package com.wks.daggertutorial.ui.main.view;


import android.support.v4.app.Fragment;

import com.wks.daggertutorial.dependencies.PerFragment;
import com.wks.daggertutorial.ui.common.view.BaseFragmentModule;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;

import static com.wks.daggertutorial.ui.common.view.BaseFragmentModule.FRAGMENT;

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
