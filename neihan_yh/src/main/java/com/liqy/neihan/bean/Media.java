package com.liqy.neihan.bean;

import java.util.List;

/**
 * Created by liqy on 2018/1/9.
 */

public class Media {

    public int width;
    public String uri;
    public int height;
    public List<Url> url_list;

    public static class Url {
        public String url;
    }

    public Media(int width, String uri, int height, List<Url> url_list) {
        this.width = width;
        this.uri = uri;
        this.height = height;
        this.url_list = url_list;
    }

    @Override
    public String toString() {
        return "Media{" +
                "width=" + width +
                ", uri='" + uri + '\'' +
                ", height=" + height +
                ", url_list=" + url_list +
                '}';
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<Url> getUrl_list() {
        return url_list;
    }

    public void setUrl_list(List<Url> url_list) {
        this.url_list = url_list;
    }
}
