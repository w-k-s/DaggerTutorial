package com.wks.daggertutorial.main;

import com.wks.daggertutorial.dependencies.PerActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * - The MainActivitySubcomponent specifies that the MainActivityModule be used to provide its dependencies.
 * - The MainActivitySubcomponent specifies  that the Builder build the subcomponent instance that will inject those dependencies into the MainActivity
 * - The subcomponent is annotated with @PerActivity indicating that the specified modules provides @PerActivity scoped and non-scoped dependencies.
 */
@PerActivity
@Subcomponent(modules = MainActivityModule.class)
public interface MainActivitySubcomponent extends AndroidInjector<MainActivity>{

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {
    }
}
