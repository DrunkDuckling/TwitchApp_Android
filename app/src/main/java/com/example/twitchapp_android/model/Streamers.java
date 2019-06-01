package com.example.twitchapp_android.model;

public class Streamers {

    String user_id, user_name, game_id, community_ids, type, title, viewer_count, started_at, language, thumbnail;


    public Streamers() {
    }

    public Streamers(String user_id, String user_name, String game_id, String community_ids, String type, String title, String viewer_count, String started_at, String language, String thumbnail) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.game_id = game_id;
        this.community_ids = community_ids;
        this.type = type;
        this.title = title;
        this.viewer_count = viewer_count;
        this.started_at = started_at;
        this.language = language;
        this.thumbnail = thumbnail;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getGame_id() {
        return game_id;
    }

    public void setGame_id(String game_id) {
        this.game_id = game_id;
    }

    public String getCommunity_ids() {
        return community_ids;
    }

    public void setCommunity_ids(String community_ids) {
        this.community_ids = community_ids;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getViewer_count() {
        return viewer_count;
    }

    public void setViewer_count(String viewer_count) {
        this.viewer_count = viewer_count;
    }

    public String getStarted_at() {
        return started_at;
    }

    public void setStarted_at(String started_at) {
        this.started_at = started_at;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Streamers{" +
                "user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", game_id='" + game_id + '\'' +
                ", community_ids='" + community_ids + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", viewer_count='" + viewer_count + '\'' +
                ", started_at='" + started_at + '\'' +
                ", language='" + language + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}