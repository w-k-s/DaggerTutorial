package com.wks.daggertutorial.examples.example1;

import android.app.Activity;
import android.app.Fragment;

import com.wks.daggertutorial.base.BaseActivityModule;
import com.wks.daggertutorial.dependencies.PerActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.FragmentKey;
import dagger.multibindings.IntoMap;

/**
 * Created by waqqassheikh on 28/02/2018.
 */
@Module(includes = BaseActivityModule.class,
subcomponents = Example1FragmentSubcomponent.class)
public abstract class Example1ActivityModule {

    @Binds
    @IntoMap
    @FragmentKey(Example1Fragment.class)
    abstract AndroidInjector.Factory<? extends Fragment>
    example1FragmentInjectorFactory(Example1FragmentSubcomponent.Builder builder);

    @Binds
    @PerActivity
    abstract Activity activity(Example1Activity activity);
}
