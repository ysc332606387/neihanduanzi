package com.liqy.neihan.bean;

import java.util.List;

/**
 * Created by liqy on 2018/1/9.
 */

public class FeedData<T> {
    public boolean has_more;
    public String tip;
    public boolean has_new_message;
    public double max_time;
    public int min_time;
    public List<T> data;


    public FeedData(boolean has_more, String tip, boolean has_new_message, double max_time, int min_time, List<T> data) {
        this.has_more = has_more;
        this.tip = tip;
        this.has_new_message = has_new_message;
        this.max_time = max_time;
        this.min_time = min_time;
        this.data = data;
    }


    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public boolean isHas_new_message() {
        return has_new_message;
    }

    public void setHas_new_message(boolean has_new_message) {
        this.has_new_message = has_new_message;
    }

    public double getMax_time() {
        return max_time;
    }

    public void setMax_time(double max_time) {
        this.max_time = max_time;
    }

    public int getMin_time() {
        return min_time;
    }

    public void setMin_time(int min_time) {
        this.min_time = min_time;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "FeedData{" +
                "has_more=" + has_more +
                ", tip='" + tip + '\'' +
                ", has_new_message=" + has_new_message +
                ", max_time=" + max_time +
                ", min_time=" + min_time +
                ", data=" + data +
                '}';
    }
}
