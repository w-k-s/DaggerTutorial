package com.wks.daggertutorial.ui.examples.example1;

import android.app.Activity;

import com.wks.daggertutorial.base.BaseActivityModule;
import com.wks.daggertutorial.dependencies.PerActivity;
import com.wks.daggertutorial.dependencies.PerFragment;
import com.wks.daggertutorial.ui.examples.example1.view.Example1Fragment;
import com.wks.daggertutorial.ui.examples.example1.view.Example1FragmentModule;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module(includes = BaseActivityModule.class)
public abstract class Example1ActivityModule {

    @PerFragment
    @ContributesAndroidInjector(modules = Example1FragmentModule.class)
    abstract Example1Fragment example1FragmentInjector();

    @Binds
    @PerActivity
    abstract Activity activity(Example1Activity activity);
}
