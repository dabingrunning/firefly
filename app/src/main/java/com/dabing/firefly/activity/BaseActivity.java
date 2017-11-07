package com.dabing.firefly.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by dabing on 2017/11/4.
 *
 * @author dabing
 *
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        handleNextAction();
    }

    protected abstract void handleNextAction();

    /**
     * @return int id - 返回布局id
     */
    protected abstract int getLayoutResourceId();

}
