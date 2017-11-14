## 练习用项目

- 逐步完善功能:

    1. 集成地图定位，分享
    2. 使用较新的Android特性
    3. 练习使用Retrofit
    4. 后期练习使用RxJava
    5. 平时遇到的坑


### 坑
####  自定义对话框
    AlertDialog 设置宽度：先show()，然后才能设置宽高
    在主题 Theme.AppCompat.Light.NoActionBar_ 下要想正常显示要调用这行代码：window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
### Retrofit
#### Retrofit 创建
>    String baseUrl  :建议总是以 /结尾
    addConverterFactory（）:可添加不同的json解析依赖
```java
        Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(baseUrl)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
```

定义接口对象
```java
    public interface ArticleService{
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
    }
```
由Retrofit 创建接口对象的代理
```java
    ArticleService articleService = retrofit.create(ArticleService.class);
    Call<ArticleList> articleList = articleService.getArticleList(0, 1, 1, "2.0", "af0b9d39f99beacaa8f94804f3ae0b91", "1510127339", "ed6aaf5fc31d787739850dab9fdc2d1f", "1.5.2");
    articleList.enqueue();//异步执行 ；execute()同步执行
```

#### 注解
------
  - @Path("userId"):<font color=#0099ff>URL占位符，用于替换和动态更新,相应的参数必须使用相同的字符串被@Path进行注释
    ，动态配置url</font>,例如：
  ``` java

    @GET("{userId}")
    Call<ResponseBody> getUserInfo(@Path("userId") String userId);

  ```
  _Note:@Path 是针对url路径而不是参数，所以 @Path("userId={userId}")是不适用_
-----