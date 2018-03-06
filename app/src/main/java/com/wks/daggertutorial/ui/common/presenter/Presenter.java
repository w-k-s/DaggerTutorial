package com.wks.daggertutorial.ui.common.presenter;

import android.os.Bundle;

/**
 * Created by waqqassheikh on 06/03/2018.
 */

public interface Presenter {
    void onStart(Bundle saveInstanceState);
    void onResume();
    void onPause();
    void onSaveInstanceState(Bundle outState);
    void onDestroy();
}
