package com.example.gitsocial;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.LifecycleObserver;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import timber.log.Timber;

public class App extends MultiDexApplication implements LifecycleObserver {
    /*
     * Sets whether vector drawables on older platforms (< API 21) can be used within
     * {@link android.graphics.drawable.DrawableContainer} resources.
     **/
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);

        if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree());
    }
}
