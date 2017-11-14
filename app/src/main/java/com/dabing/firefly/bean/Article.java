package com.dabing.firefly.bean;

/**
 * Created by dabing on 2017/11/9.
 */

public class Article {
    private String id;
    private String title;
    private String image;
    private String number;
    private String favorite_num;
    private String praise_num;
    private String tag_type_ids;
    private String tag_type_desc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFavorite_num() {
        return favorite_num;
    }

    public void setFavorite_num(String favorite_num) {
        this.favorite_num = favorite_num;
    }

    public String getPraise_num() {
        return praise_num;
    }

    public void setPraise_num(String praise_num) {
        this.praise_num = praise_num;
    }

    public String getTag_type_ids() {
        return tag_type_ids;
    }

    public void setTag_type_ids(String tag_type_ids) {
        this.tag_type_ids = tag_type_ids;
    }

    public String getTag_type_desc() {
        return tag_type_desc;
    }

    public void setTag_type_desc(String tag_type_desc) {
        this.tag_type_desc = tag_type_desc;
    }
}
