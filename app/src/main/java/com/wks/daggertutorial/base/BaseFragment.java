package com.wks.daggertutorial.base;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;

/**
 * Created by waqqassheikh on 26/02/2018.
 */

public class BaseFragment extends Fragment implements HasFragmentInjector {

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

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            // Perform injection here before M, L (API 22) and below because onAttach(Context)
            // is not yet available at L.
            AndroidInjection.inject(this);
        }
        super.onAttach(activity);
    }

    @Override
    public void onAttach(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Perform injection here for M (API 23) due to deprecation of onAttach(Activity).
            AndroidInjection.inject(this);
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
    public AndroidInjector<Fragment> fragmentInjector() {
        return fragmentInjector;
    }
}
