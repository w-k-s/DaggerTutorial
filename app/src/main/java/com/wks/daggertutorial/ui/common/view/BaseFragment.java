package com.wks.daggertutorial.ui.common.view;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by waqqassheikh on 06/03/2018.
 */

public class BaseFragment extends Fragment implements HasSupportFragmentInjector{
    /**
     * The activity Context, which is provided by the BaseActivityModule, is injected here
     */
    @Inject
    protected Context activityContext;

    /**
     *  Note that this should not be used within a child fragment.
     */
    @Inject
    @Named(BaseFragmentModule.CHILD_FRAGMENT_MANAGER)
    protected FragmentManager childFragmentManager;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;

    private Unbinder unbinder;

    @Override
    public void onAttach(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Perform injection here for M (API 23) due to deprecation of onAttach(Activity).
            AndroidSupportInjection.inject(this);
        }
        super.onAttach(context);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        /* No need to check if getView() is null because this lifecycle method will
         * not get called if the view returned in onCreateView, if any, is null.
         *
          * We bind the views in onViewStateRestored instead of in onCreateView or onViewCreated
          * so that view state changed listeners are not invoked automatically without user interaction.
          * If we bind before this method (e.g. onViewCreated),
          * then any OnCheckedChangeListener (and other such listeners) bound by Butterknife
          * (or without Butterknife) will be invoked during fragment recreation
          * (since Android itself saves and restores the views’ states),
          * which may produce unwanted (or wanted) side effects.
         */
        unbinder = ButterKnife.bind(this,getView());
    }

    protected final void addChildFragment(@IdRes int containerViewId, Fragment fragment) {
        childFragmentManager.beginTransaction()
                .add(containerViewId, fragment)
                .commit();
    }

    @Override
    public void onDestroyView() {


        if (unbinder != null){
            unbinder.unbind();
        }
        super.onDestroyView();
    }

    //-- HasFragmentInjector

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentInjector;
    }
}
