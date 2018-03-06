package com.wks.daggertutorial.ui.examples.example1.view;

import android.app.Fragment;

import com.wks.daggertutorial.base.BaseFragmentModule;
import com.wks.daggertutorial.dependencies.PerFragment;
import com.wks.daggertutorial.ui.examples.example1.presenter.Example1PresenterModule;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;

/**
 * Created by waqqassheikh on 28/02/2018.
 */

@Module(includes = {BaseFragmentModule.class, Example1PresenterModule.class})
public abstract class Example1FragmentModule {

    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragment
    abstract Fragment fragment(Example1Fragment fragment);

    @Binds
    @PerFragment
    abstract Example1View example1View(Example1Fragment fragment);
}
