package com.dabing.firefly.util.param;

import retrofit2.http.Field;

/**
 * Created by dabing on 2017/11/9.
 */

public class Params {
    public Params(int type,int page,int origin,String api_version,String sign,String t,String token,String version){
        this.type = type;
        this.page = page;
        this.origin = origin;
        this.api_version = api_version;
        this.sign = sign;
        this.t =t;
        this.token = token;
        this.version = version;
    }
    int type;
    int page;
    int origin;
    String api_version;
    String sign;
    String t;
    String token;
    String version;
}
