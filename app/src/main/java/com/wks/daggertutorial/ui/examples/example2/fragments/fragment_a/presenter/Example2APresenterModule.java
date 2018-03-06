package com.wks.daggertutorial.ui.examples.example2.fragments.fragment_a.presenter;

import dagger.Binds;
import dagger.Module;

/**
 * Created by waqqassheikh on 06/03/2018.
 */
@Module
public abstract class Example2APresenterModule {

    @Binds
    abstract Example2APresenter example2APresenter(Example2APresenterImpl presenter);
}
