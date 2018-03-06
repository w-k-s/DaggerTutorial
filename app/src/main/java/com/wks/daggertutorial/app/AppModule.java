package com.wks.daggertutorial.app;

import com.wks.daggertutorial.dependencies.PerActivity;
import com.wks.daggertutorial.ui.examples.example1.Example1Activity;
import com.wks.daggertutorial.ui.examples.example1.Example1ActivityModule;
import com.wks.daggertutorial.ui.examples.example2.Example2Activity;
import com.wks.daggertutorial.ui.examples.example2.Example2ActivityModule;
import com.wks.daggertutorial.ui.main.MainActivity;
import com.wks.daggertutorial.ui.main.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * The AppModule is an abstract class that is annotated with the @Module annotation and includes the AndroidInjectionModule,
 * AndroidInjectionModule contains bindings to ensure the usability of dagger.android framework classes
 */
@Module(includes = AndroidSupportInjectionModule.class)
public abstract class AppModule {


    @PerActivity
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity mainActivityInjector();

    @PerActivity
    @ContributesAndroidInjector(modules = Example1ActivityModule.class)
    abstract Example1Activity example1ActivityInjector();

    @PerActivity
    @ContributesAndroidInjector(modules = Example2ActivityModule.class)
    abstract Example2Activity example2ActivityInjector();
    
}
