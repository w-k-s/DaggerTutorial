package com.wks.daggertutorial.util;

import android.support.v4.app.Fragment;

import com.wks.daggertutorial.dependencies.PerFragment;

import javax.inject.Inject;
import javax.inject.Named;

import static com.wks.daggertutorial.ui.common.view.BaseFragmentModule.FRAGMENT;


/**
 * The PerFragmentUtil is scoped with @PerFragment.
 * This means that the Fragment and all of its child fragments and their dependencies will
 * share the same instance of this class.
 * <p>
 * However, different fragment instances will have their own instances.
 * <p>
 * This is not available at the Activity and Application level.
 */
@PerFragment
public class PerFragmentUtil {

    private final Fragment fragment;

    @Inject
    public PerFragmentUtil(@Named(FRAGMENT) Fragment fragment) {
        this.fragment = fragment;
    }

    /**
     *
     * The doSomething() method returns the instance’s and fragment’s hashCode.
     * This will be used later on to verify that the same instance is used in all child Fragments of each (parent) Fragment though each (parent) Fragment will have their own instance.
     */
    public String doSomething(){
        return String.format("%s...%s",getClass().getSimpleName(),hashCode());
    }
}
