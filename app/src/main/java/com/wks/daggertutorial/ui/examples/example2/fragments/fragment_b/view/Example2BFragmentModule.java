package com.wks.daggertutorial.ui.examples.example2.fragments.fragment_b.view;


import android.support.v4.app.Fragment;

import com.wks.daggertutorial.dependencies.PerFragment;
import com.wks.daggertutorial.ui.common.view.BaseFragmentModule;
import com.wks.daggertutorial.ui.examples.example2.fragments.fragment_b.presenter.Example2BPresenterModule;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;

/**
 * Created by waqqassheikh on 28/02/2018.
 */

@Module(includes = {BaseFragmentModule.class, Example2BPresenterModule.class})
public abstract class Example2BFragmentModule {
    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragment
    abstract Fragment fragment(Example2BFragment example2BFragment);

    @Binds
    @PerFragment
    abstract Example2BView example2BView(Example2BFragment example2BFragment);
}
