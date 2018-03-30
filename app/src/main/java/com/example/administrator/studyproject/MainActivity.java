package com.example.administrator.studyproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button test;
    private Button test1;
    private Button test2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        test = (Button) findViewById(R.id.test);
        test.setOnClickListener(this);
        test1 = (Button) findViewById(R.id.test1);
        test1.setOnClickListener(this);
        test2 = (Button) findViewById(R.id.test2);
        test2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.test:
                getDatasync();
                break;
            case R.id.test1:
                break;
            case R.id.test2:
                break;
        }
    }

    private void getDatasync() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://www.baidu.com")
                        .build();
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                    if (response.isSuccessful()) {
                        Log.e(getClass().getSimpleName(), response.code() + "");
                        Log.e(getClass().getSimpleName(), response.message());
                        Log.e(getClass().getSimpleName(), response.body().string());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e(getClass().getSimpleName(),e.getMessage());
                }
            }
        }).start();
    }
}
