package com.liqy.neihan.bean;

/**
 * Created by liqy on 2018/1/9.
 */

public class HttpResult<T> {
    public String message;
    public FeedData<T> data;


    public HttpResult(String message, FeedData<T> data) {
        this.message = message;
        this.data = data;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public FeedData<T> getData() {
        return data;
    }

    public void setData(FeedData<T> data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "HttpResult{" +
                "message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
