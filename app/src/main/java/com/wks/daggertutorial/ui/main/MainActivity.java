package com.wks.daggertutorial.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.wks.daggertutorial.R;
import com.wks.daggertutorial.base.BaseActivity;
import com.wks.daggertutorial.ui.main.view.MainFragment;

public class MainActivity extends BaseActivity implements MainFragmentListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            addFragment(R.id.fragment_container, new MainFragment());
        }
    }

    @Override
    public void onExample1Clicked() {
        navigator.toExample1(this);
    }

    @Override
    public void onExample2Clicked() {
        navigator.toExample2(this);
    }

    @Override
    public void onExample3Clicked() {
        // TODO start example 3 activity
        Toast.makeText(this, "Launch example 3", Toast.LENGTH_SHORT).show();
    }
}
