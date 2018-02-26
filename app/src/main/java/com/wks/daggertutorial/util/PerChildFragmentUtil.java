package com.wks.daggertutorial.util;

import android.support.v4.app.Fragment;

import com.wks.daggertutorial.dependencies.PerChildFragment;

import javax.inject.Inject;
import javax.inject.Named;

import static com.wks.daggertutorial.base.BaseChildFragmentModule.CHILD_FRAGMENT;

/**
 * The PerChildFragmentUtil is scoped with @PerChildFragment.
 * This means that the child Fragment (a fragment inside a fragment that is added using Fragment.getChildFragmentManager())
 * and all of its dependencies will share the same instance of this class.
 *
 * However, different child fragments instances will have their own instances of this class.
 *
 * This is not available at the (parent) Fragment, Activity, and Application level.
 */
@PerChildFragment
public class PerChildFragmentUtil {

    private final Fragment childFragment;

    @Inject
    private PerChildFragmentUtil(@Named(CHILD_FRAGMENT) Fragment fragment){
        this.childFragment = fragment;
    }

    /**
     * The doSomething() method returns the instance’s and child fragment’s hashCode.
     *
     * This will be used later on to verify that no same instance is used in different child fragments.
     * @return
     */
    public String doSomething(){
        return String.format("%s...%s",getClass().getSimpleName(),hashCode());
    }
}
