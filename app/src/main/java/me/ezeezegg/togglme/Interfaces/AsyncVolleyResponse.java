package me.ezeezegg.togglme.Interfaces;

import org.json.JSONObject;

/**
 * Created by egarcia on 7/5/16.
 */
public interface AsyncVolleyResponse {
    void AsyncVolleyFinish(JSONObject jsonObject);
    void AsyncVolleyError(JSONObject jsonObject);
}
