## 练习用项目

- 逐步完善功能:

    1. 集成地图定位，分享
    2. 使用较新的Android特性
    3. 练习使用Retrofit +RxJava

### Retrofit
 - 注解
  + @Path("userId"):<font color=#0099ff>动态配置url</font>,例如：
  ``` Java

    @GET("{userId}")
    Call<ResponseBody> getUserInfo(@Path("userId") String userId);

  ```
  Note:@Path 是针对url路径而不是参数，所以 @Path("userId={userId}")是不适用