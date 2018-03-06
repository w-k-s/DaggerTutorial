package com.wks.daggertutorial.ui.examples.example2;

import android.app.Activity;

import com.wks.daggertutorial.base.BaseActivityModule;
import com.wks.daggertutorial.dependencies.PerActivity;
import com.wks.daggertutorial.dependencies.PerFragment;
import com.wks.daggertutorial.ui.examples.example2.fragments.fragment_a.view.Example2AFragment;
import com.wks.daggertutorial.ui.examples.example2.fragments.fragment_a.view.Example2AFragmentModule;
import com.wks.daggertutorial.ui.examples.example2.fragments.fragment_b.view.Example2BFragment;
import com.wks.daggertutorial.ui.examples.example2.fragments.fragment_b.view.Example2BFragmentModule;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(includes = BaseActivityModule.class)
public abstract class Example2ActivityModule {

    @Binds
    @PerActivity
    abstract Activity activity(Example2Activity activity);


    @PerFragment
    @ContributesAndroidInjector(modules = Example2AFragmentModule.class)
    abstract Example2AFragment example2AFragmentInjector();

    @PerFragment
    @ContributesAndroidInjector(modules = Example2BFragmentModule.class)
    abstract Example2BFragment example2BFragmentInjector();

}
