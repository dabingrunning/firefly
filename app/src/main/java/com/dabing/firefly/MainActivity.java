package com.dabing.firefly;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;

import com.dabing.firefly.activity.welcome.SecondActivity;
import com.dabing.firefly.activity.welcome.WelcomeActivity;
import com.dabing.firefly.retrofitService.ArticleService;
import com.dabing.firefly.util.RetrofitUtil;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.text_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.activity_in,R.anim.activity_out);
            }
        });
        RetrofitUtil init = RetrofitUtil.init();
        Retrofit build = init.build();
        ArticleService articleService = build.create(ArticleService.class);
        Call<ResponseBody> articleList = articleService.getArticleList(0, 1, 1, "2.0", "af0b9d39f99beacaa8f94804f3ae0b91", "1510127339", "ed6aaf5fc31d787739850dab9fdc2d1f", "1.5.2");
        articleList.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    System.out.println(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
