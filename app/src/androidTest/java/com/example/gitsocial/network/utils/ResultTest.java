package com.example.gitsocial.network.utils;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ResultTest extends TestCase {
    Context appContext;

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

    public void testParser() {
    }

    public void testJson() {
    }

    public void testParse() {
    }
}