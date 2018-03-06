package com.wks.daggertutorial.ui.examples.example2.fragments.fragment_a.presenter;

import com.wks.daggertutorial.dependencies.PerFragment;

import dagger.Binds;
import dagger.Module;

/**
 * Created by waqqassheikh on 06/03/2018.
 */
@Module
public abstract class Example2APresenterModule {

    @Binds
    @PerFragment
    abstract Example2APresenter example2APresenter(Example2APresenterImpl presenter);
}
