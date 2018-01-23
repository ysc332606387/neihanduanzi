package com.liqy.neihan.bean;

/**
 * 奖章
 * Created by liqy on 2018/1/9.
 */

public class Medal {
    public int count;
    public String icon_url;
    public String name;
    public String small_icon_url;


    public Medal(int count, String icon_url, String name, String small_icon_url) {
        this.count = count;
        this.icon_url = icon_url;
        this.name = name;
        this.small_icon_url = small_icon_url;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSmall_icon_url() {
        return small_icon_url;
    }

    public void setSmall_icon_url(String small_icon_url) {
        this.small_icon_url = small_icon_url;
    }

    @Override
    public String toString() {
        return "Medal{" +
                "count=" + count +
                ", icon_url='" + icon_url + '\'' +
                ", name='" + name + '\'' +
                ", small_icon_url='" + small_icon_url + '\'' +
                '}';
    }
}
