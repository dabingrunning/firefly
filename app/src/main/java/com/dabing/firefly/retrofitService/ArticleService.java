package com.dabing.firefly.retrofitService;

import com.dabing.firefly.bean.ArticleList;
import com.dabing.firefly.util.param.Params;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by dabing on 2017/11/8.
 */
public interface ArticleService {
    @FormUrlEncoded
    @POST("new_api/huazhen_article/index")
    Call<ArticleList> getArticleList(@Field("type") int type,
                                     @Field("page") int page,
                                     @Field("origin") int origin,
                                     @Field("api_version") String api_version,
                                     @Field("sign") String sign,
                                     @Field("t") String t,
                                     @Field("token") String token,
                                     @Field("version") String version);
    @FormUrlEncoded
    @POST("new_api/huazhen_article/index")
    Call<ArticleList> getArticleList(@FieldMap Map<String,String> map);

    @POST("new_api/huazhen_article/index")
    Call<ArticleList> getArticleList(@Body Params params);
    @GET("Top25")
    Call<ResponseBody> getTop25(@Query("start") int start,@Query("count") int count);
}
