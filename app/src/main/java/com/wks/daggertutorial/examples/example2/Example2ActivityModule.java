package com.wks.daggertutorial.examples.example2;

import android.app.Activity;
import android.app.Fragment;

import com.wks.daggertutorial.base.BaseActivityModule;
import com.wks.daggertutorial.dependencies.PerActivity;
import com.wks.daggertutorial.examples.example2.fragments.fragment_a.Example2AFragment;
import com.wks.daggertutorial.examples.example2.fragments.fragment_a.Example2AFragmentSubcomponent;
import com.wks.daggertutorial.examples.example2.fragments.fragment_b.Example2BFragment;
import com.wks.daggertutorial.examples.example2.fragments.fragment_b.Example2BFragmentSubcomponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.FragmentKey;
import dagger.multibindings.IntoMap;

/**
 * Created by waqqassheikh on 28/02/2018.
 */

@Module(includes = BaseActivityModule.class,
        subcomponents = {Example2AFragmentSubcomponent.class, Example2BFragmentSubcomponent.class})
public abstract class Example2ActivityModule {

    @Binds
    @PerActivity
    abstract Activity activity(Example2Activity activity);

    /**
     * An injector factory i.e. something that can inject the dependencies of Example2BFragment
     */
    @Binds
    @IntoMap
    @FragmentKey(Example2AFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> example2AFragmentInjectorFactory(Example2AFragmentSubcomponent.Builder builder);

    /**
     * An injector factory i.e. something that can inject the dependencies of Example2BFragment
     */
    @Binds
    @IntoMap
    @FragmentKey(Example2BFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> example2BFragmentInjectorFactory(Example2BFragmentSubcomponent.Builder builder);
}
