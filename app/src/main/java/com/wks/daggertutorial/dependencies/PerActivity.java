package com.wks.daggertutorial.dependencies;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * The @PerActivity scoping annotation specifies that the lifespan of a dependency be the same as that of an Activity.
 *
 * This is used to annotate dependencies that behave like a singleton within the lifespan of an Activity, Fragment, and child Fragments instead of the entire Application.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
