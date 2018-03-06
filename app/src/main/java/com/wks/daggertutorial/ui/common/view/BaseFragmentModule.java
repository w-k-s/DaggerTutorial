package com.wks.daggertutorial.ui.common.view;

import android.app.Fragment;
import android.app.FragmentManager;

import com.wks.daggertutorial.dependencies.PerFragment;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by waqqassheikh on 06/03/2018.
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
