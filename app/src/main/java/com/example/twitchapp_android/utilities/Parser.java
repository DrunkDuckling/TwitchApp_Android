package com.example.twitchapp_android.utilities;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.twitchapp_android.R;
import com.example.twitchapp_android.adapter.RecyclerViewAdapter;
import com.example.twitchapp_android.model.Categories;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static List<Categories> parseCategories(JSONObject res){

        List<Categories> categoriesList;
        categoriesList = new ArrayList<>();
        try {
            JSONArray objects = res.getJSONArray("data");
            for(int i = 0; i<objects.length(); i++){
                JSONObject o = objects.getJSONObject(i);
                System.out.println(o.getString("name"));
                categoriesList.add(new Categories(o.getString("name"), o.getString("id"), "", o.getString("box_art_url").replace("{height}", "200").replace("{width}", "150")));
            }
        } catch(JSONException e){
            System.out.println(e.toString());
        }
        return categoriesList;
    }
}
