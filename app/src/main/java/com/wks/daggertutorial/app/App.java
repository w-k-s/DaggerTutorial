package com.wks.daggertutorial.app;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Dependencies are shared from top to bottom. Activities have access to Application @Singleton dependencies
 *
 * The entry point of all dependency injection is the App, which implements HasActivityInjector.
 * HasActivityInjector provides a DispatchingAndroidInjector<Activity> (injected via Dagger).
 * DispatchingAndroidInjector<Activity> enabled activities to participate in dagger.android injection.
 */
public class App extends Application implements HasActivityInjector{

    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerAppComponent.create().inject(this);
    }

    //-- HasActivityInjector


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }
}
