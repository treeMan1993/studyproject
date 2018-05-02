package com.example.administrator.studyproject.Bean;

/**
 * Created by Administrator on 2018/4/11 0011.
 */

public class EventMessage {
    private String message;
    public EventMessage(String message){
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
