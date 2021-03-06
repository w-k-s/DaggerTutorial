package com.wks.daggertutorial.ui.main.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wks.daggertutorial.R;
import com.wks.daggertutorial.ui.common.view.BaseFragment;
import com.wks.daggertutorial.ui.main.MainFragmentListener;

import javax.inject.Inject;

import butterknife.OnClick;

/**
 * Created by waqqassheikh on 26/02/2018.
 */

public class MainFragment extends BaseFragment {

    @Inject
    MainFragmentListener listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @OnClick(R.id.example_1)
    void onExample1Clicked() {
        listener.onExample1Clicked();
    }

    @OnClick(R.id.example_2)
    void onExample2Clicked() {
        listener.onExample2Clicked();
    }

    @OnClick(R.id.example_3)
    void onExample3Clicked() {
        listener.onExample3Clicked();
    }
}
