package com.dabing.firefly.util;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dabing on 2017/11/7.
 */

public class RetrofitUtil {
    private  Retrofit retrofit;
    private static String baseUrl = "http://www.huazhen.com/";
    private RetrofitUtil(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        OkHttpClient client = builder.build();

        retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static RetrofitUtil init(){
        RetrofitUtil retrofitUtil = new RetrofitUtil();
        return retrofitUtil;
    }


    public Retrofit build(){
        return  retrofit;
    }

}
