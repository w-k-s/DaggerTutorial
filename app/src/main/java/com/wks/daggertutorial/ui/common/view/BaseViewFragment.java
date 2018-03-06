package com.wks.daggertutorial.ui.common.view;

import android.os.Bundle;

import com.wks.daggertutorial.ui.common.presenter.Presenter;

import javax.inject.Inject;

/**
 * Created by waqqassheikh on 06/03/2018.
 */

public class BaseViewFragment<T extends Presenter> extends BaseFragment implements View {

    @Inject
    protected T presenter;

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        presenter.onStart(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    public void onDestroyView() {
        presenter.onDestroy();
        super.onDestroyView();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(outState);
    }

}
