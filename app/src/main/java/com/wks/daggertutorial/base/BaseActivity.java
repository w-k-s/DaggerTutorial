package com.wks.daggertutorial.base;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;

/**
 * Created by waqqassheikh on 26/02/2018.
 */

public class BaseActivity extends Activity implements HasFragmentInjector{

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;

    @Inject
    @Named(BaseActivityModule.ACTIVITY_FRAGMENT_MANAGER)
    protected FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    protected final void addFragment(@IdRes int containerViewId, Fragment fragment) {
        fragmentManager.beginTransaction()
                .add(containerViewId, fragment)
                .commit();
    }

    //-- HasFragmentInjector

    @Override
    public final AndroidInjector<Fragment> fragmentInjector() {
        return fragmentInjector;
    }
}
