package com.example.gitsocial.network.utils;

import com.example.gitsocial.domain.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class Result {
    public static final String TAG = Result.class.getSimpleName();
    private String json;

    public static Result parser() {
        return new Result();
    }

    public Result() { }

    public Result json(String result) {
        this.json = result;
        return this;
    }

    public ArrayList<User> parse() {
        ArrayList<User> mUsers = new ArrayList<>();
        try {
            JSONArray response = new JSONArray(json);

            for (int i = 0; i < response.length(); i++) {
                JSONObject post = response.optJSONObject(i);

                mUsers.add(User.builder()
                        .avatar_url(post.getString("avatar_url"))
                        .login(post.optString("login"))
                        .build());
            }

            return mUsers;
        } catch (JSONException e) {
            e.printStackTrace();
            return mUsers;
        }
    }
}
