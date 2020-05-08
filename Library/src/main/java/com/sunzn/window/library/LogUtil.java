package com.sunzn.window.library;

import android.util.Log;

public class LogUtil {

    private static final String TAG = "FloatWindow";

    public static void e(String message) {
        Log.e(TAG, message);
    }

    public static void d(String message) {
        Log.d(TAG, message);
    }

}
