package com.example.twitchapp_android.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.twitchapp_android.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentTransaction mainFt = getSupportFragmentManager().beginTransaction();
        Fragment main = CategoryFragment.newInstance();
        mainFt.replace(R.id.fragment_container, main, "CategoryFrament");
        mainFt.commit();
        }
}