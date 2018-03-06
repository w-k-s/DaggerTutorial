package com.wks.daggertutorial.ui.common.presenter;

import android.os.Bundle;

import com.wks.daggertutorial.ui.common.view.View;

/**
 * Created by waqqassheikh on 06/03/2018.
 */

public class BasePresenter<T extends View> implements Presenter {

    protected final T view;

    protected BasePresenter(T view) {
        this.view = view;
    }

    @Override
    public void onStart(Bundle saveInstanceState) {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void onDestroy() {

    }
}
