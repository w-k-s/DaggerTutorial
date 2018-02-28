package com.wks.daggertutorial.util;

import android.app.Activity;

import com.wks.daggertutorial.dependencies.PerActivity;

import javax.inject.Inject;

/**
 * The PerActivityUtil is scoped with @PerActivity.
 * This means that the Activity and all of its Fragments and child Fragments and their dependencies
 * will share the same instance of this class.
 *
 * However, different activity instances will have their own instances.
 *
 * This is not available at the Application level.
 *
 */
@PerActivity
public class PerActivityUtil {

    private final Activity activity;

    @Inject
    public PerActivityUtil(Activity activity){
        this.activity = activity;
    }


    /**
     * The doSomething() method returns the instance’s and activity’shashCode.
     *
     * This will be used later on to verify that the same instance is used in all Fragments
     * and child Fragments of each Activity though each Activity will have their own instance.
     * @return
     */
    public String doSomething(){
        return String.format("%s...%s",getClass().getSimpleName(),hashCode());
    }
}
