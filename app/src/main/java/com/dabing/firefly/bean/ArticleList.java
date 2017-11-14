package com.dabing.firefly.bean;

import java.util.List;

/**
 * Created by dabing on 2017/11/9.
 */

public class ArticleList {
    private int errcode;
    private String errmsg;
    private Content data;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Content getData() {
        return data;
    }

    public void setData(Content data) {
        this.data = data;
    }

}