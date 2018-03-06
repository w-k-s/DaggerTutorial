package com.wks.daggertutorial.ui.main;

import android.support.v7.app.AppCompatActivity;

import com.wks.daggertutorial.base.BaseActivityModule;
import com.wks.daggertutorial.dependencies.PerActivity;
import com.wks.daggertutorial.dependencies.PerFragment;
import com.wks.daggertutorial.ui.main.view.MainFragment;
import com.wks.daggertutorial.ui.main.view.MainFragmentModule;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * - The MainActivityModule specifies that the MainFragmentSubcomponent is a subcomponent of this module
 * (thereby gaining access to this activity’s, and in turn the application’s, dependencies).
 *
 */
@Module(includes = BaseActivityModule.class)
public abstract class MainActivityModule {

    /**
     * The activity method takes in a concrete activity, in this case MainActivity,
     * as per the contract specified in BaseActivityModule.
     */
    @Binds
    @PerActivity
    abstract AppCompatActivity mainActivity(MainActivity mainActivity);

    /**
     * The mainFragmentListener takes in the MainActivity, which implements MainFragmentListener,
     * and binds it into the MainFragment that expects a MainFragmentListener to be injected.
     */
    @Binds
    @PerActivity
    abstract MainFragmentListener mainFragmentListener(MainActivity mainActivity);

    @PerFragment
    @ContributesAndroidInjector(modules = MainFragmentModule.class)
    abstract MainFragment mainFragmentInjector();
}
