package com.wks.daggertutorial.main;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.wks.daggertutorial.base.BaseActivityModule;
import com.wks.daggertutorial.dependencies.PerActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

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
    abstract Activity mainActivity(MainActivity mainActivity);

    /**
     * The mainFragmentListener takes in the MainActivity, which implements MainFragmentListener,
     * and binds it into the MainFragment that expects a MainFragmentListener to be injected.
     */
    @Binds
    @PerActivity
    abstract MainFragmentListener mainFragmentListener(MainActivity mainActivity);

    // TODO (ContributesAndroidInjector) remove this in favor of @ContributesAndroidInjector

    /**
     * As we said earlier, if a subactivity extends BaseActivity, then the subactivity's module
     * must extend the BaseActivity's module to provide its dependencies.
     *
     * The BaseActivity has a dependency of DispatchingAndroidInjector<Fragment>. The module is providing it.
     * The MainFragmentSubcomponent includes the MainFragmentModule. The MainFragmentModule provides the fragment to be injected.
     *
     * The mainFragmentInjectorFactory method takes in the MainFragmentSubcomponent.Builder
     * and returns the AndroidInjectorFactory. This provides the injector for the MainFragment.
     *
     */
    @Binds
    @IntoMap
    @FragmentKey(MainFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> mainFragmentInjectorFactory(MainFragmentSubcomponent.Builder builder);
}
