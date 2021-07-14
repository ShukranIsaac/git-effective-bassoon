package com.example.gitsocial.ui.home;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.gitsocial.domain.User;
import com.example.gitsocial.data.network.utils.Result;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class Downloader extends AsyncTask<String, Void, Integer> {
    public static final String TAG = Downloader.class.getSimpleName();
    private ProgressBar progressBar;
    private Context mContext;
    private List<User> mUsers;
    private RecyclerView mRecyclerView;

    public Downloader() { }

    public Downloader(Builder builder) {
        this.progressBar = builder.progressBar;
        this.mContext = builder.mContext;
        this.mRecyclerView = builder.mRecyclerView;
    }

    public Builder toBuilder() {
        return builder();
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    protected void onPreExecute() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected Integer doInBackground(String... params) {
        int result = 0;
        HttpURLConnection urlConnection;
        try {
            URL url = new URL(params[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            int statusCode = urlConnection.getResponseCode();

            // 200 represents HTTP OK
            if (statusCode == 200) {
                BufferedReader r = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = r.readLine()) != null) {
                    response.append(line);
                }

                mUsers = new ArrayList<>();
                mUsers.addAll(Result.parser().json(response.toString()).parse());

                result = 1; // Successful
            } else {
                result = 0; //"Failed to fetch data!";
            }
        } catch (Exception e) {
            Timber.d(e.getLocalizedMessage());
        }
        return result; //"Failed to fetch data!";
    }

    @Override
    protected void onPostExecute(Integer result) {
        progressBar.setVisibility(View.GONE);

        if (result == 1) {
            mRecyclerView.setAdapter(new HomeViewAdapter(mContext, mUsers));
        } else {
            Toast.makeText(mContext, "Failed to fetch data!", Toast.LENGTH_SHORT).show();
        }
    }

    public static class Builder {
        private ProgressBar progressBar;
        private Context mContext;
        private RecyclerView mRecyclerView;
        private String url;

        public Builder progressBar(ProgressBar progressBar) {
            this.progressBar = progressBar;
            return this;
        }

        public Builder context(Context mContext) {
            this.mContext = mContext;
            return this;
        }

        public Builder data(String url) {
            this.url = url;
            return this;
        }

        public Builder view(RecyclerView mRecyclerView) {
            this.mRecyclerView = mRecyclerView;
            return this;
        }

        public void download() {
            Downloader downloader = new Downloader(this);
            downloader.execute(url);
        }
    }
}
