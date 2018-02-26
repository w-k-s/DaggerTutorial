package com.wks.daggertutorial.base;

import dagger.Module;

/**
 * The BaseChildFragmentModule provides the base child fragment dependencies.
 *
 * The module of the subclasses of the BaseChildFragment are required to INCLUDE the BaseChildFragmentModule
 * and PROVIDE a concrete implementation of the Fragment named CHILD_FRAGMENT
 */
@Module
public abstract class BaseChildFragmentModule {

    public static final String CHILD_FRAGMENT = "BaseChildFragmentModule.childFragment";

}
