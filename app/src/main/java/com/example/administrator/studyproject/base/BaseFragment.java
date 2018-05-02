package com.example.administrator.studyproject.base;

import com.example.administrator.studyproject.Utils.LogUtils;

/**
 * Created by Administrator on 2018/4/1 0001.
 */

public class BaseFragment {
    public String TAG = getClass().getSimpleName();

    public void v(String message) {
        LogUtils.v(TAG, message);
    }

    public void d(String message) {
        LogUtils.d(TAG, message);
    }

    public void i(String message) {
        LogUtils.i(TAG, message);
    }

    public void w(String message) {
        LogUtils.w(TAG, message);
    }

    public void e(String message) {
        LogUtils.e(TAG, message);
    }
}
