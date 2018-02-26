package com.wks.daggertutorial.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wks.daggertutorial.R;
import com.wks.daggertutorial.base.BaseFragment;

import javax.inject.Inject;

/**
 * Created by waqqassheikh on 26/02/2018.
 */

public class MainFragment extends BaseFragment implements View.OnClickListener{

    @Inject
    MainFragmentListener listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // TODO (Butterknife) replace with butterknife view binding
        view.findViewById(R.id.example_1).setOnClickListener(this);
        view.findViewById(R.id.example_2).setOnClickListener(this);
        view.findViewById(R.id.example_3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.example_1:
                onExample1Clicked();
                break;
            case R.id.example_2:
                onExample2Clicked();
                break;
            case R.id.example_3:
                onExample3Clicked();
                break;
            default:
                throw new IllegalArgumentException("Unhandled view " + v.getId());
        }
    }

    private void onExample1Clicked() {
        listener.onExample1Clicked();
    }

    private void onExample2Clicked() {
        listener.onExample2Clicked();
    }

    private void onExample3Clicked() {
        listener.onExample3Clicked();
    }
}
