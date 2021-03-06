package com.wks.daggertutorial.base;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.wks.daggertutorial.dependencies.PerActivity;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * The BaseActivityModule provides the base activity dependencies:
 * - the activity Context
 * - the activity FragmentManager named ACTIVITY_FRAGMENT_MANAGER
 *
 * The module of the subclasses of the BaseActivity are required to INCLUDE the BaseActivityModule
 * and PROVIDE a concrete implementation of the Activity.
 *
 * This makes sense because a subclass of BaseActivity should provide a module
 * that is a subclass of BaseActivityModule so that the dependencies of BaseActivity can be resolved.
 */
@Module
public abstract class BaseActivityModule {
    static final String ACTIVITY_FRAGMENT_MANAGER = "BaseActivityModule.activityFragmentManager";

    @Binds
    @PerActivity
    abstract Context activityContext(AppCompatActivity activity);

    @Provides
    @Named(ACTIVITY_FRAGMENT_MANAGER)
    @PerActivity
    static FragmentManager activityFragmentManager(AppCompatActivity activity) {
        return activity.getSupportFragmentManager();
    }
}
