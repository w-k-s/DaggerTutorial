package com.wks.daggertutorial.examples.example1;

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

public class Example1Fragment extends BaseFragment implements View.OnClickListener{

    @Inject SingletonUtil singletonUtil;
    @Inject PerActivityUtil perActivityUtil;
    @Inject PerFragmentUtil perFragmentUtil;

    private TextView someText;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.example_1_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // TODO (Butterknife) replace with butterknife view binding
        someText = (TextView) view.findViewById(R.id.some_text);
        view.findViewById(R.id.do_something).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.do_something:
                onDoSomethingClicked();
                break;
            default:
                throw new IllegalArgumentException("Unhandled view " + v.getId());
        }
    }

    private void onDoSomethingClicked() {
        String something = singletonUtil.doSomething();
        something += "\n" + perActivityUtil.doSomething();
        something += "\n" + perFragmentUtil.doSomething();
        showSomething(something);
    }

    private void showSomething(String something) {
        someText.setText(something);
    }
}
