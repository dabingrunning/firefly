package com.dabing.firefly.retrofitService;

import com.dabing.firefly.util.param.Params;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

/**
 * Created by dabing on 2017/11/9.
 */

public interface UploadFileService {
    @Multipart
    @POST("/new_api/huazhen_dataRequest/user_head_image")
    Call<ResponseBody> uploadFile(@Part("origin") RequestBody origin,
                                  @Part("api_version") RequestBody api_version,
                                  @Part("sign") RequestBody sign,
                                  @Part("t") RequestBody t,
                                  @Part("token") RequestBody token,
                                  @Part("version") RequestBody version, @Part MultipartBody.Part file);

    @Multipart
    @POST("http://182.92.172.193:9000/upload")
    Call<ResponseBody> uploadFile(@Part MultipartBody.Part file);
}
