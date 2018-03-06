package com.wks.daggertutorial.ui.main.view;

import com.wks.daggertutorial.dependencies.PerFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * This MainFragmentSubcomponent interface is used by Dagger to inject dependencies to the MainFragment
 *
 * - The MainFragmentSubcomponent specifies that the MainFragmentModule be used to provide MainFragment dependencies.
 * - the Builder build the subcomponent instance that will inject those dependencies into the MainFragment
 * - The subcomponent is annotated with @PerFragment indicating that the specified modules provides @PerFragment scoped and non-scoped dependencies
 */
@PerFragment
@Subcomponent(modules = MainFragmentModule.class)
public interface MainFragmentSubcomponent extends AndroidInjector<MainFragment> {

    /**
     * Notice that the Builder is really barebones.
     * This will allow later on to use @ContributesAndroidInjector to automatically provide the subcomponent injectors, thereby removing the need to have @Subcomponent classes.
     */
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainFragment> {
    }
}
