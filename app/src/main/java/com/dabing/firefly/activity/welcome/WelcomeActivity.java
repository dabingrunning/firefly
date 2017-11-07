package com.dabing.firefly.activity.welcome;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import com.dabing.firefly.MainActivity;
import com.dabing.firefly.R;
import com.dabing.firefly.activity.BaseActivity;

/**
 * Created by dabing on 2017/11/4.
 */

public class WelcomeActivity extends BaseActivity {
    Handler handler = new Handler();
    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_welcome;
    }
    @Override
    protected void handleNextAction() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.setClass(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.activity_in,R.anim.activity_out);
                finish();
            }
        },1000);
    }

    @Override
    public void finish() {
        super.finish();
//        overridePendingTransition(R.anim.activity_in,R.anim.activity_out);
    }
}
