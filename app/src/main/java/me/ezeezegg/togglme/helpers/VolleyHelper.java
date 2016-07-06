package me.ezeezegg.togglme.helpers;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import me.ezeezegg.togglme.Interfaces.AsyncVolleyResponse;
import me.ezeezegg.togglme.applications.VolleyApplication;

/**
 * Created by egarcia on 7/5/16.
 */
public class VolleyHelper {
    private Context context;
    private String url;
    private JSONObject jsonObject;
    private AsyncVolleyResponse asyncVolleyResponse;

    public VolleyHelper(Context context, String url, JSONObject jsonObject, AsyncVolleyResponse asyncVolleyResponse) {
        this.context = context;
        this.url = url;
        this.jsonObject = jsonObject;
        this.asyncVolleyResponse = asyncVolleyResponse;
    }

    public void makeVolleyRequest(){
        JsonObjectRequest request = new JsonObjectRequest(url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        request.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        VolleyApplication.getInstance().getRequestQueue().add(request);
    }
}
