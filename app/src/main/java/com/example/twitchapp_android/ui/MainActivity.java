package com.example.twitchapp_android.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.twitchapp_android.R;
import com.example.twitchapp_android.model.StreamAPISetting;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentTransaction mainFt = getSupportFragmentManager().beginTransaction();
        Fragment main = CategoryFragment.newInstance();
        mainFt.replace(R.id.fragment_container, main);
        mainFt.commit();



        requestWithSomeHttpHeaders();
        
        }

    public void requestWithSomeHttpHeaders() {
        //Retrieving the request URL from SETTINGS.
        String url = StreamAPISetting.getRequestTopGames();

        //Initiates response listener from Volley library
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        })
        {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Client-ID", StreamAPISetting.getClientId());
                params.put("Accept", StreamAPISetting.getHeaderAccept());
                return params;
            }
        };
        //Adds the request to the Queue
        MySingleton.getInstance(this).addToRequestQueue(jsonObjReq);
    }
}