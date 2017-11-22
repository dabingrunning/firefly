package com.dabing.firefly.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Created by dabing on 2017/11/4.
 *
 * @author dabing
 *
 */

public abstract class BaseActivity extends AppCompatActivity {
    private String appSecret = "687bb4eb9494e6e7203e8b3436fed4a0";//微信
    private String AppID = "wx8c8c541bc5cd8db0";//微信
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        IWXAPI wxapi = WXAPIFactory.createWXAPI(this, AppID);
        handleNextAction();
    }

    protected abstract void handleNextAction();

    /**
     * @return int id - 返回布局id
     */
    protected abstract int getLayoutResourceId();

}
