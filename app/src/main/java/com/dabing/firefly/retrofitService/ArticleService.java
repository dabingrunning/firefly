package com.dabing.firefly.retrofitService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by dabing on 2017/11/8.
 */
public interface ArticleService {
    @FormUrlEncoded
    @POST("new_api/huazhen_article/index")
    Call<ResponseBody> getArticleList(@Field("type") int type,
                                      @Field("page") int page,
                                      @Field("origin") int origin,
                                      @Field("api_version") String api_version,
                                      @Field("sign") String sign,
                                      @Field("t") String t,
                                      @Field("token") String token,
                                      @Field("version") String version);
}
