package com.example.administrator.studyproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.administrator.studyproject.Bean.EventMessage;
import com.example.administrator.studyproject.base.BaseActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button test;
    private Button test1;
    private Button test2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        EventBus.getDefault().register(this);
    }

    private void initView() {
        test = (Button) findViewById(R.id.test);
        test.setOnClickListener(this);
        test1 = (Button) findViewById(R.id.test1);
        test1.setOnClickListener(this);
        test2 = (Button) findViewById(R.id.test2);
        test2.setOnClickListener(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Receive(EventMessage eventMessage){
        Log.e("SJH","接收到数据了");
            test1.setText(eventMessage.getMessage());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.test:
                getDatasync();
                break;
            case R.id.test1:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        EventBus.getDefault().post(new EventMessage("哈哈哈"));
                    }
                }).start();

                break;
            case R.id.test2:
                EventBus.getDefault().post(new EventMessage("第三个按钮发送"));
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private void getDatasync() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://www.baidu.com")
                        .build();
                Request.Builder builder = new Request.Builder();
                Response response = null;
                Call call = client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        if (response.isSuccessful()) {
                            e(response.code() + "");
                            e(response.message());
                            e(response.body().string());
                        }
                    }
                });
                try {
                    response = client.newCall(request).execute();
                    if (response.isSuccessful()) {

                        e(response.code() + "");
                        e(response.message());
                        e(response.body().string());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    e(e.getMessage());
                }
            }
        }).start();
    }
}
