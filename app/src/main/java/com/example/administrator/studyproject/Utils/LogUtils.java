package com.example.administrator.studyproject.Utils;

import android.util.Log;

/**
 * Created by Administrator on 2018/4/1 0001.
 */

public class LogUtils {
    private final static int mLogLevel = 5;

    public static void v(String TAG,String message) {
        if (mLogLevel >= 1) {
            Log.v(TAG, message);
        }
    }

    public static void d(String TAG,String message) {
        if (mLogLevel >= 2) {
            Log.d(TAG, message);
        }
    }

    public static void i(String TAG,String message) {
        if (mLogLevel >= 3) {
            Log.i(TAG, message);
        }
    }

    public static void w(String TAG,String message) {
        if (mLogLevel >= 4) {
            Log.w(TAG, message);
        }
    }

    public static void e(String TAG,String message) {
        if (mLogLevel >= 5) {
            Log.e(TAG, message);
        }
    }
}
