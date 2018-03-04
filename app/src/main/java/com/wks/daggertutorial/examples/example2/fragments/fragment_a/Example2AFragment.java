package com.wks.daggertutorial.examples.example2.fragments.fragment_a;

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

/**
 * Created by waqqassheikh on 28/02/2018.
 */

public class Example2AFragment extends BaseFragment implements View.OnClickListener {

    @Inject
    SingletonUtil singletonUtil;

    @Inject PerActivityUtil perActivityUtil;

    @Inject PerFragmentUtil perFragmentUtil;

    private TextView someText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.example_2_fragment_a, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        someText = view.findViewById(R.id.some_text);
        view.findViewById(R.id.do_something).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.do_something:
                doSomething();
        }
    }

    private void doSomething() {
        String something = singletonUtil.doSomething();
        something += "\n" + perActivityUtil.doSomething();
        something += "\n" + perFragmentUtil.doSomething();
        showSomething(something);
    }

    private void showSomething(String something) {
        someText.setText(something);
    }
}
