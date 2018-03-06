package com.wks.daggertutorial.ui.examples.example2.fragments.fragment_b.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wks.daggertutorial.R;
import com.wks.daggertutorial.ui.common.view.BaseViewFragment;
import com.wks.daggertutorial.ui.examples.example2.fragments.fragment_b.presenter.Example2BPresenter;

import butterknife.BindView;
import butterknife.OnClick;


public class Example2BFragment extends BaseViewFragment<Example2BPresenter> implements Example2BView{

    @BindView(R.id.some_text) TextView someText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.example_2_fragment_b, container, false);
    }

    @OnClick(R.id.do_something)
    void doSomething() {
        presenter.onDoSomething();
    }

    @Override
    public void showSomething(String something) {
        someText.setText(something);
    }
}
