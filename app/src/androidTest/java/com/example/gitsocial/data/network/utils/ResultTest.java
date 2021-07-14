package com.example.gitsocial.data.network.utils;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.gitsocial.R;
import com.example.gitsocial.domain.User;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@RunWith(AndroidJUnit4.class)
public class ResultTest extends TestCase {
    private Context appContext;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        // Context of the app under test.
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
    }

    @After
    public void tearDown() throws Exception {
        appContext = null;
    }

    @Test
    public void testAppContext() {
        assertEquals("com.example.gitsocial", appContext.getPackageName());
    }

    @Test
    public void testParse() throws IOException {
        InputStream inputStream = appContext.getResources().openRawResource(R.raw.test_users);
        BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder data = new StringBuilder();
        String line;
        while ((line = r.readLine()) != null) {
            data.append(line);
        }

        // parse json data to Java Objects - POJOs
        User user = Result.parser().json(data.toString()).parse().get(0);

        // test for equality - respective object properties
        assertEquals("Pitson3", user.login());
        assertEquals("38654407", user.id());
    }
}