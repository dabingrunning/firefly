package com.dabing.firefly.util;

import android.util.Log;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dabing on 2017/11/7.
 */

public class RetrofitUtil {
    private  Retrofit retrofit;
    private static String baseUrl = "http://www.huazhen.com/";
    public static final String BASE_URL = "https://api.douban.com/v2/movie/";
    private RetrofitUtil(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.addInterceptor(new Interceptor() {
            private final Charset UTF8 = Charset.forName("UTF-8");
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder().addHeader("ss","ss").build();
                RequestBody requestBody = request.body();
                Log.e("请求方法：",request.method());
                Log.e("请求url：",request.url().toString());
                String body = null;
                if(requestBody != null) {
                    Buffer buffer = new Buffer();
                    requestBody.writeTo(buffer);
                    Charset charset = UTF8;
                    MediaType contentType = requestBody.contentType();
                    if (contentType != null) {
                        charset = contentType.charset(UTF8);
                    }
                    body = buffer.readString(charset);
                }

                Log.e("请求体：",body);
                String s = request.headers().toString();
                Log.e("请求头：",s);
                Response response = chain.proceed(request);
                ResponseBody responseBody = response.body();
                Headers headers = response.headers();
                String rBody = null;

                if(responseBody!=null) {
                    BufferedSource source = responseBody.source();
                    source.request(Long.MAX_VALUE); // Buffer the entire body.
                    Buffer buffer = source.buffer();

                    Charset charset = UTF8;
                    MediaType contentType = responseBody.contentType();
                    if (contentType != null) {
                        try {
                            charset = contentType.charset(UTF8);
                        } catch (UnsupportedCharsetException e) {
                            e.printStackTrace();
                        }
                    }
                    rBody = buffer.clone().readString(charset);
                }
                Log.e("响应体：",rBody);
                Log.e("响应头：",headers.toString());
                return response;
            }
        });
        OkHttpClient client = builder.build();

        retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
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
