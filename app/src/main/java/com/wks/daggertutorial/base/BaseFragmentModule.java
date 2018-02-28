package com.wks.daggertutorial.base;


import android.app.Fragment;
import android.app.FragmentManager;

import com.wks.daggertutorial.dependencies.PerFragment;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * The BaseFragmentModule provides the base fragment dependencies:
 * - the activity Context
 * - the child FragmentManager named CHILD_FRAGMENT_MANAGER
 *
 * The module of the subclasses of the BaseFragment are required to INCLUDE the BaseFragmentModule
 * and PROVIDE a concrete implementation of the BaseFragment.
 *
 * This makes sense because a subclass of BaseFragment should provide a module
 * that is a subclass of BaseFragmentModule so that the dependencies of BaseFragment can be resolved.
 */
@Module
public abstract class BaseFragmentModule {

    public static final String FRAGMENT = "BaseFragmentModule.fragment";

    static final String CHILD_FRAGMENT_MANAGER = "BaseFragmentModule.childFragmentManager";

    /**
     * Fragmnet is named to ensure that a Parent fragment is provided
     * @param fragment
     * @return
     */
    @Provides
    @PerFragment
    @Named(CHILD_FRAGMENT_MANAGER)
    static FragmentManager childSupportFragmentManager(@Named(FRAGMENT)Fragment fragment){
        return fragment.getChildFragmentManager();
    }
}
