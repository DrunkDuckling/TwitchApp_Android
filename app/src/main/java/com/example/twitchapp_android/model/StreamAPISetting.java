package com.example.twitchapp_android.model;

public class StreamAPISetting {
    private static final String TAG = "StreamAPISetting";

    public static final String CLIENT_ID = "3qxo3afo7iywypheuycmgg5u7b5yv3";
    public static final String HEADER_ACCEPT = "application/vnd.twitchtv.v5+json";

    public static final String REQUEST_TOP_GAMES = "https://api.twitch.tv/helix/games/top";
    public static final String REQUEST_STREAMS = "https://api.twitch.tv/helix/streams?game_id=";

    public static String getRequestTopStreams() {
        return REQUEST_TOP_STREAMS;
    }

    public static final String REQUEST_TOP_STREAMS = "https://api.twitch.tv/helix/streams?first=20";

    public static String getClientId() {
        return CLIENT_ID;
    }

    public static String getHeaderAccept() {
        return HEADER_ACCEPT;
    }

    public static String getRequestTopGames() {
        return REQUEST_TOP_GAMES;
    }




}
