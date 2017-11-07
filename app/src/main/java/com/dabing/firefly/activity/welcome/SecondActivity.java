package com.dabing.firefly.activity.welcome;

import android.view.View;

import com.dabing.firefly.R;
import com.dabing.firefly.activity.BaseActivity;

/**
 * Created by dabing on 2017/11/7.
 */

public class SecondActivity extends BaseActivity {
    @Override
    protected void handleNextAction() {
            findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_second;
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_exit_in,R.anim.activity_exit_out);
    }
}
