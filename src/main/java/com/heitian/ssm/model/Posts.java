package com.heitian.ssm.model;

import java.util.Date;

/**
 * Created by Administrator on 2017/10/11.
 */
public class Posts {
    private Integer id;
    private String imageAddress;
    private String kind;
    private String tittle;
    private String content;
    private String url;
    private Integer scan_num;
    private String class_fuck;
    private Boolean is_user_praise;
    private Integer praise_num;
    private String comments_url;

    public String getComments_url() {
        return comments_url;
    }

    public void setComments_url(String comments_url) {
        this.comments_url = comments_url;
    }

    public Integer getPraise_num() {
        return praise_num;
    }

    public void setPraise_num(Integer praise_num) {
        this.praise_num = praise_num;
    }

    public Boolean getIs_user_praise() {
        return is_user_praise;
    }

    public void setIs_user_praise(Boolean is_user_praise) {
        this.is_user_praise = is_user_praise;
    }

    public String getClass_fuck() {
        return class_fuck;
    }

    public void setClass_fuck(String class_fuck) {
        this.class_fuck = class_fuck;
    }

    public Integer getScan_num() {
        return scan_num;
    }

    public void setScan_num(Integer scan_num) {
        this.scan_num = scan_num;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }
}
