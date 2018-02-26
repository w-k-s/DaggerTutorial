package com.wks.daggertutorial.dependencies;

import javax.inject.Scope;

/**
 * The @PerChildFragment custom scoping annotation specifies that the lifespan of a dependency be the same as that of a child Fragment (a fragment inside a fragment that is added using Fragment.getChildFragmentManager()).
 *
 * This is used to annotate dependencies that behave like a singleton within the lifespan of a child Fragment instead of the entire Application, Activity, or parent Fragment.
 */
@Scope
public @interface PerChildFragment {
}
