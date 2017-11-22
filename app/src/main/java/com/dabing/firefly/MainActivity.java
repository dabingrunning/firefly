package com.dabing.firefly;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dabing.firefly.bean.ArticleList;
import com.dabing.firefly.photopicker.BottomPickerDialog;
import com.dabing.firefly.retrofitService.ArticleService;
import com.dabing.firefly.retrofitService.UploadFileService;
import com.dabing.firefly.util.RetrofitUtil;
import com.dabing.firefly.util.param.Params;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends Activity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RetrofitUtil init = RetrofitUtil.init();
        Retrofit build = init.build();
        final ArticleService articleService = build.create(ArticleService.class);
        final UploadFileService uploadFileService = build.create(UploadFileService.class);

        textView = (TextView) findViewById(R.id.text_view);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //    =====================上传图片=====================
                    File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "cutimg.png");
                    RequestBody responseBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                    RequestBody responseBody1 = RequestBody.create(null, "1");
                    RequestBody responseBody2 = RequestBody.create(null, "2.0");
                    RequestBody responseBody3 = RequestBody.create(null, "79ea9ef4f29c80e9fff0a62e00cb1971");
                    RequestBody responseBody4 = RequestBody.create(null, "1510219407");
                    RequestBody responseBody5 = RequestBody.create(null, "ed6aaf5fc31d787739850dab9fdc2d1f");
                    RequestBody responseBody6 = RequestBody.create(null, "1.5.2");

                    MultipartBody.Part files = MultipartBody.Part.createFormData("avatar", file.getName(), responseBody);
                    Call<ResponseBody> responseBodyCall = uploadFileService.uploadFile(files);
//                    responseBodyCall.enqueue(new Callback<ResponseBody>() {
//                        @Override
//                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                            try {
//                                System.out.println(response.body().string());
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//                        }
//                    })
//      =====================================上传图片=====================
//          ===========================底部弹窗===========================
//                    new BottomPickerDialog(MainActivity.this).show();
//                    Call<ResponseBody> responseCall = uploadFileService.uploadFile(responseBody1,responseBody2,responseBody3,
//                            responseBody4,responseBody5,responseBody6,files);
//                    responseCall.enqueue(new Callback<ResponseBody>() {
//                        @Override
//                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                            try {
//                                System.out.println(response.body().string());
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//                        }
//                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
//          ======================================================
//                Call<ResponseBody> top25 = articleService.getTop25(0, 25);
//                top25.enqueue(new Callback<ResponseBody>() {
//                    @Override
//                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                        try {
//                            int code = response.code();
////                            String string = response.body().string();
//                            Log.e("TOP",code+"");
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseBody> call, Throwable t) {
//                        Log.e("TOP", t.getMessage());
//                    }
//
//                });
                Call<ArticleList> articleList1 = articleService.getArticleList(new Params(0,1,1,"2.0","af0b9d39f99beacaa8f94804f3ae0b91","1510127339"
                        ,"ed6aaf5fc31d787739850dab9fdc2d1f","1.5.2"));
                articleList1.enqueue(new Callback<ArticleList>() {
                    @Override
                    public void onResponse(Call<ArticleList> call, Response<ArticleList> response) {
                        try {
                            textView.setText(response.body().getData().getArticle().getData().get(1).getTitle());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleList> call, Throwable t) {
                        Toast.makeText(MainActivity.this,t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
//                Call<ArticleList> articleList = articleService.getArticleList(0, 1, 1, "2.0", "af0b9d39f99beacaa8f94804f3ae0b91", "1510127339", "ed6aaf5fc31d787739850dab9fdc2d1f", "1.5.2");
//                articleList.enqueue(new Callback<ArticleList>() {
//                    @Override
//                    public void onResponse(Call<ArticleList> call, Response<ArticleList> response) {
//                        try {
//                            System.out.println(response.body().getData().getArticle().getData().get(1).getTitle());
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<ArticleList> call, Throwable t) {
//
//                    }
//                });
//                Intent intent = new Intent();
//                intent.setClass(MainActivity.this, SecondActivity.class);
//                startActivity(intent);
//                overridePendingTransition(R.anim.activity_in,R.anim.activity_out);
            }
        });
    }
}
