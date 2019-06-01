package com.example.twitchapp_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Anime> animeList;

            animeList = new ArrayList<>();
            animeList.add(new Anime("Black Clover", "Adventure/Fantasy", "Anime description", R.drawable.blackclover));
            animeList.add(new Anime("Boruto", "Adventure/Fantasy/Ninja", "Anime description", R.drawable.boruto));
            animeList.add(new Anime("Dragon Ball Super", "Adventure/Fantasy/Fighting", "Anime description", R.drawable.dragonball));
            animeList.add(new Anime("Fairy Tail", "Adventure/Fantasy/Super Power/Magic", "Anime description", R.drawable.fairy_tail));
            animeList.add(new Anime("One Piece", "Adventure/Fantasy/Pirates/Super power", "Anime description", R.drawable.one_piece));
            animeList.add(new Anime("Black Clover", "Adventure/Fantasy", "Anime description", R.drawable.blackclover));
            animeList.add(new Anime("Boruto", "Adventure/Fantasy/Ninja", "Anime description", R.drawable.boruto));
            animeList.add(new Anime("Dragon Ball Super", "Adventure/Fantasy/Fighting", "Anime description", R.drawable.dragonball));
            animeList.add(new Anime("Fairy Tail", "Adventure/Fantasy/Super Power/Magic", "Anime description", R.drawable.fairy_tail));
            animeList.add(new Anime("One Piece", "Adventure/Fantasy/Pirates/Super power", "Anime description", R.drawable.one_piece));


            RecyclerView myRv = (RecyclerView) findViewById(R.id.rcView_id);
            RecyclerViewAdapter mAdapter = new RecyclerViewAdapter(this, animeList);
            myRv.setLayoutManager(new GridLayoutManager(this, 3));
            myRv.setAdapter(mAdapter);

        }
    }