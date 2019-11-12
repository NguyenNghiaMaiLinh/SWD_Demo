package com.example.myappandroid.Model;

import java.io.Serializable;
import java.util.Date;

public class Discount implements Serializable {
    private String id;
    private String title;
    private String urlImage;
    private String status;
    private String startAt;
    private String EndAt;
    private String Code;

    public Discount(String id, String title, String urlImage, String status, String startAt, String endAt, String code) {
        this.id = id;
        this.title = title;
        this.urlImage = urlImage;
        this.status = status;
        this.startAt = startAt;
        EndAt = endAt;
        Code = code;
    }

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

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public String getEndAt() {
        return EndAt;
    }

    public void setEndAt(String endAt) {
        EndAt = endAt;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }
}
