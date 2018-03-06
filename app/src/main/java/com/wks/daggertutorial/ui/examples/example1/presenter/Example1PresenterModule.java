package com.wks.daggertutorial.ui.examples.example1.presenter;

import com.wks.daggertutorial.dependencies.PerFragment;

import dagger.Binds;
import dagger.Module;

/**
 * Created by waqqassheikh on 06/03/2018.
 */
@Module
public abstract class Example1PresenterModule {

    @Binds
    @PerFragment
    abstract Example1Presenter example1Presenter(Example1PresenterImpl presenter);
}
