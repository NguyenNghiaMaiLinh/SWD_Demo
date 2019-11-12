package com.example.myappandroid.Model;

import java.io.Serializable;

public class Banner implements Serializable {
    private String id;
    private String bannerName;
    private String urlImage;

    public Banner(String id, String urlImage) {
        this.id = id;
        this.urlImage = urlImage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
