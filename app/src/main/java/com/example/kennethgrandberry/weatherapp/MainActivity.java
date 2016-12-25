package com.example.kennethgrandberry.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    //urls
    final String URL_Base = "http://api.openweathermap.org/data/2.5/forecast";
    final String URL_COORD = "/?lat=35.105&lon=-89.840";
    final String URL_UNITS = "&units=imperial";
    final String URL_API_KEY = "&APPID=7fba1493634df010704ff49eac7e30b4";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String url = URL_Base + URL_COORD +URL_UNITS + URL_API_KEY;

        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
             Log.v("FUN","RES:" + response.toString());


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("FUN","Err:" + error.getLocalizedMessage());

            }
        });

        Volley.newRequestQueue(this).add(jsonObjectRequest);
    }
}
