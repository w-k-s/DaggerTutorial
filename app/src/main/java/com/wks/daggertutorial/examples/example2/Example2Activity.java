package com.wks.daggertutorial.examples.example2;

import android.os.Bundle;

import com.wks.daggertutorial.R;
import com.wks.daggertutorial.base.BaseActivity;
import com.wks.daggertutorial.examples.example2.fragments.fragment_a.Example2AFragment;
import com.wks.daggertutorial.examples.example2.fragments.fragment_b.Example2BFragment;

/**
 * Created by waqqassheikh on 28/02/2018.
 */

public class Example2Activity extends BaseActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example2);

        if (savedInstanceState == null) {
            addFragment(R.id.fragment_container1, new Example2AFragment());
            addFragment(R.id.fragment_container2, new Example2BFragment());
        }
    }
}
