package com.example.twitchapp_android.model;

import android.graphics.drawable.Drawable;

public class Categories {

    private String Title, Id;
    Drawable Thumbnail;

    public Categories() {
    }

    public Categories(String title, String id, Drawable thumbnail) {
        Title = title;
        Id = id;
        Thumbnail = thumbnail;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getId() {
        return Id;
    }

    public void setId(String category) {
        Id = category;
    }

    public Drawable getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(Drawable thumbnail) {
        Thumbnail = thumbnail;
    }
}
