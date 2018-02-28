package com.wks.daggertutorial.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.wks.daggertutorial.R;
import com.wks.daggertutorial.base.BaseActivity;
import com.wks.daggertutorial.examples.example1.Example1Activity;
import com.wks.daggertutorial.examples.example2.Example2Activity;

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
        // TODO start example 1 activity
        Intent intent = new Intent(this, Example1Activity.class);
        startActivity(intent);
    }

    @Override
    public void onExample2Clicked() {
        Intent intent = new Intent(this, Example2Activity.class);
        startActivity(intent);
    }

    @Override
    public void onExample3Clicked() {
        // TODO start example 3 activity
        Toast.makeText(this, "Launch example 3", Toast.LENGTH_SHORT).show();
    }
}
