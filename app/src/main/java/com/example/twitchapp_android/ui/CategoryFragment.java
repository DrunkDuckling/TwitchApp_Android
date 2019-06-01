package com.example.twitchapp_android.ui;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.twitchapp_android.R;
import com.example.twitchapp_android.adapter.RecyclerViewAdapter;
import com.example.twitchapp_android.model.Categories;
import com.example.twitchapp_android.model.StreamAPISetting;
import com.example.twitchapp_android.utilities.MySingleton;
import com.example.twitchapp_android.utilities.Parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CategoryFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoryFragment extends Fragment {

    private static final String TAG = "CategoryFragment";

    private List<Categories> cats;

    private RecyclerViewAdapter mAdapter;

    private OnFragmentInteractionListener mListener;

    public CategoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment CategoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CategoryFragment newInstance() {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        /*
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);*/
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void requestWithSomeHttpHeaders() {
        //Retrieving the request URL from SETTINGS.
        String url = StreamAPISetting.getRequestTopGames();

        //Initiates response listener from Volley library
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                for (Categories c: Parser.parseCategories(response)) {
                    cats.add(c);
                }
                System.out.println(cats.get(4).getId());
                mAdapter.notifyDataSetChanged();
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
        MySingleton.getInstance(this.getActivity()).addToRequestQueue(jsonObjReq);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        requestWithSomeHttpHeaders();

        cats = new ArrayList<>();

        RecyclerView myRv = view.findViewById(R.id.rcView_id);
        mAdapter = new RecyclerViewAdapter(this.getActivity(), cats);
        myRv.setLayoutManager(new GridLayoutManager(this.getActivity(), 3));
        myRv.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new RecyclerViewAdapter.onItemClickListener() {
            @Override
            public void onClick(Categories cat) {
                StreamersFragment SF = StreamersFragment.newInstance(cat.getCategory());
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, SF, "CategoryFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }*/

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
