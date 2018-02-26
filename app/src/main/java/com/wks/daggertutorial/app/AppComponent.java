package com.wks.daggertutorial.app;

import javax.inject.Singleton;

import dagger.Component;

/**
 * The AppComponent is annotated with @Component and @Singleton to indicate that its modules (AppModule) are to provide @Singleton scoped or unscoped dependencies.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(App app);
}
