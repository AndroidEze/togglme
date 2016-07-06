package me.ezeezegg.togglme.helpers;

import android.content.Context;

import org.json.JSONObject;

import me.ezeezegg.togglme.Interfaces.AsyncVolleyResponse;

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
}
