package com.wks.daggertutorial.navigation;

import android.content.Context;
import android.content.Intent;

import com.wks.daggertutorial.ui.examples.example1.Example1Activity;
import com.wks.daggertutorial.ui.examples.example2.Example2Activity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by waqqassheikh on 06/03/2018.
 */

@Singleton
public class Navigator {

    @Inject
    public Navigator(){}

    public void toExample1(Context context) {
        Intent intent = new Intent(context, Example1Activity.class);
        context.startActivity(intent);
    }

    public void toExample2(Context context) {
        Intent intent = new Intent(context, Example2Activity.class);
        context.startActivity(intent);
    }

}
