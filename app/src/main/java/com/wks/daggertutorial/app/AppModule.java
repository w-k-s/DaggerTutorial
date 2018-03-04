package com.wks.daggertutorial.app;

import com.wks.daggertutorial.dependencies.PerActivity;
import com.wks.daggertutorial.examples.example1.Example1Activity;
import com.wks.daggertutorial.examples.example1.Example1ActivityModule;
import com.wks.daggertutorial.examples.example2.Example2Activity;
import com.wks.daggertutorial.examples.example2.Example2ActivityModule;
import com.wks.daggertutorial.main.MainActivity;
import com.wks.daggertutorial.main.MainActivityModule;

import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;

/**
 * The AppModule is an abstract class that is annotated with the @Module annotation and includes the AndroidInjectionModule,
 * AndroidInjectionModule contains bindings to ensure the usability of dagger.android framework classes
 */
@Module(includes = AndroidInjectionModule.class)
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
