package com.wks.daggertutorial.examples.example1;

import android.os.Bundle;

import com.wks.daggertutorial.R;
import com.wks.daggertutorial.base.BaseActivity;

public class Example1Activity extends BaseActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example1);

        if (savedInstanceState == null) {
            addFragment(R.id.fragment_container, new Example1Fragment());
        }
    }
}
