package com.wks.daggertutorial.ui.examples.example2.fragments.fragment_a.view;

import android.app.Fragment;

import com.wks.daggertutorial.base.BaseFragmentModule;
import com.wks.daggertutorial.dependencies.PerFragment;
import com.wks.daggertutorial.ui.examples.example2.fragments.fragment_a.presenter.Example2APresenterModule;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;

/**
 * Created by waqqassheikh on 28/02/2018.
 */
@Module(includes = {
        BaseFragmentModule.class,
        Example2APresenterModule.class
})
public abstract class Example2AFragmentModule {

    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragment
    abstract Fragment fragment(Example2AFragment example2AFragment);

    @Binds
    @PerFragment
    abstract Example2AView example2BView(Example2AFragment example2AFragment);
}
