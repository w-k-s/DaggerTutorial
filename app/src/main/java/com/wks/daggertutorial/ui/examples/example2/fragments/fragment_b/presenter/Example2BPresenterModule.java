package com.wks.daggertutorial.ui.examples.example2.fragments.fragment_b.presenter;

import com.wks.daggertutorial.dependencies.PerFragment;

import dagger.Binds;
import dagger.Module;

/**
 * Created by waqqassheikh on 06/03/2018.
 */
@Module
public abstract class Example2BPresenterModule {

    @Binds
    @PerFragment
    abstract Example2BPresenter example2BPresenter(Example2BPresenterImpl presenter);
}
