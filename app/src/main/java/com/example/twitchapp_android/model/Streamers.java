package com.example.twitchapp_android.model;

import android.graphics.drawable.Drawable;

public class Streamers {

    String stream_id, user_name;
    Drawable thumbnail;


    public Streamers() {
    }

    public Streamers(String user_id, String user_name, Drawable thumbnail) {
        this.stream_id = user_id;
        this.user_name = user_name;

        this.thumbnail = thumbnail;
    }

    public String getUser_id() {
        return stream_id;
    }

    public void setUser_id(String user_id) {
        this.stream_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Drawable getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Drawable thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Streamers{" +
                "user_id='" + stream_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}