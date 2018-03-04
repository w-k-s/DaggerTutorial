package com.wks.daggertutorial.examples.example2.fragments.fragment_b;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wks.daggertutorial.R;
import com.wks.daggertutorial.base.BaseFragment;
import com.wks.daggertutorial.util.PerActivityUtil;
import com.wks.daggertutorial.util.PerFragmentUtil;
import com.wks.daggertutorial.util.SingletonUtil;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;


public class Example2BFragment extends BaseFragment{

    @Inject
    SingletonUtil singletonUtil;

    @Inject PerActivityUtil perActivityUtil;

    @Inject PerFragmentUtil perFragmentUtil;

    @BindView(R.id.some_text) TextView someText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.example_2_fragment_b, container, false);
    }

    @OnClick(R.id.do_something)
    void doSomething() {
        String something = singletonUtil.doSomething();
        something += "\n" + perActivityUtil.doSomething();
        something += "\n" + perFragmentUtil.doSomething();
        showSomething(something);
    }

    private void showSomething(String something) {
        someText.setText(something);
    }
}
