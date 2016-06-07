package com.sodo.kumail.prayerapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

/**
 * Created by kumail on 6/3/2016.
 */

public class FragmentA extends Fragment {

    RequestQueue requestQueue;

    GridView gridView;


    public View onCreateView(LayoutInflater layoutInflater, ViewGroup parent, Bundle bundle)
    {
        return layoutInflater.inflate(R.layout.fragment_a,parent,false);
    }

    public void getJson()
    {
        requestQueue=RequestQSingleton.getRequestQueue();

        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, "", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(jsonObjectRequest);
        

    }

}
