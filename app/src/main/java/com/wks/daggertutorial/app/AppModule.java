package com.wks.daggertutorial.app;

import android.app.Activity;

import com.wks.daggertutorial.main.MainActivity;
import com.wks.daggertutorial.main.MainActivitySubcomponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * The AppModule is an abstract class that is annotated with the @Module annotation and includes the AndroidInjectionModule,
 * AndroidInjectionModule contains bindings to ensure the usability of dagger.android framework classes
 *
 *
 */
@Module(includes = AndroidInjectionModule.class)
public abstract class AppModule {


    /**
     * AppModule satisfies the dependencies of App.
     * AppModule has one dependency: DispatchingAndroidInjector<Activity>. this method provides that dependency.
     * The dependency uses a MainactivitySubcomponent.Builder which in turn uses the MainActivityModule to provide
     * the MainActivity.
     *
     * TODO (ContributesAndroidInjector) remove this in favor of @ContributesAndroidInjector
     */
    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    mainActivityInjectorFactory(MainActivitySubcomponent.Builder builder);
}
