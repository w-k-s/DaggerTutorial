package com.wks.daggertutorial.util;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * The SingletonUtil is scoped with @Singleton.
 *
 * This means that the Application and all Activities, Fragments, and child Fragments
 * and their dependencies will share the same single instance of this class.
 */
@Singleton
public class SingletonUtil {

    /**
     * Inject constructor arguments (there aren't any)
     */
    @Inject
    public SingletonUtil(){

    }

    public String doSomething(){
        return String.format("%s...%s",getClass().getSimpleName(),hashCode());
    }
}