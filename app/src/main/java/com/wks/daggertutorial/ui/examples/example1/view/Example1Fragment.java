package com.wks.daggertutorial.ui.examples.example1.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wks.daggertutorial.R;
import com.wks.daggertutorial.ui.common.view.BaseViewFragment;
import com.wks.daggertutorial.ui.examples.example1.presenter.Example1Presenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by waqqassheikh on 28/02/2018.
 */

public class Example1Fragment extends BaseViewFragment<Example1Presenter> implements Example1View{

    @BindView(R.id.some_text) TextView someText;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.example_1_fragment, container, false);
    }

    @OnClick(R.id.do_something)
    void onDoSomethingClicked() {
       presenter.onDoSomething();
    }

    @Override
    public void showSomething(String something) {
        someText.setText(something);
    }
}
