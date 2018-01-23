package com.liqy.neihan.bean;

import java.util.List;

/**
 * Created by liqy on 2018/1/9.
 */

public class User {
    public boolean is_living;
    public long user_id;
    public String name;
    public int followings;
    public boolean user_verified;
    public int ugc_count;
    public String avatar_url;
    public int followers;
    public boolean is_following;
    public boolean is_pro_user;
    public List<Medal> medals;


    public User(boolean is_living, long user_id, String name, int followings, boolean user_verified, int ugc_count, String avatar_url, int followers, boolean is_following, boolean is_pro_user, List<Medal> medals) {
        this.is_living = is_living;
        this.user_id = user_id;
        this.name = name;
        this.followings = followings;
        this.user_verified = user_verified;
        this.ugc_count = ugc_count;
        this.avatar_url = avatar_url;
        this.followers = followers;
        this.is_following = is_following;
        this.is_pro_user = is_pro_user;
        this.medals = medals;
    }


    public boolean isIs_living() {
        return is_living;
    }

    public void setIs_living(boolean is_living) {
        this.is_living = is_living;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFollowings() {
        return followings;
    }

    public void setFollowings(int followings) {
        this.followings = followings;
    }

    public boolean isUser_verified() {
        return user_verified;
    }

    public void setUser_verified(boolean user_verified) {
        this.user_verified = user_verified;
    }

    public int getUgc_count() {
        return ugc_count;
    }

    public void setUgc_count(int ugc_count) {
        this.ugc_count = ugc_count;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public boolean isIs_following() {
        return is_following;
    }

    public void setIs_following(boolean is_following) {
        this.is_following = is_following;
    }

    public boolean isIs_pro_user() {
        return is_pro_user;
    }

    public void setIs_pro_user(boolean is_pro_user) {
        this.is_pro_user = is_pro_user;
    }

    public List<Medal> getMedals() {
        return medals;
    }

    public void setMedals(List<Medal> medals) {
        this.medals = medals;
    }


    @Override
    public String toString() {
        return "User{" +
                "is_living=" + is_living +
                ", user_id=" + user_id +
                ", name='" + name + '\'' +
                ", followings=" + followings +
                ", user_verified=" + user_verified +
                ", ugc_count=" + ugc_count +
                ", avatar_url='" + avatar_url + '\'' +
                ", followers=" + followers +
                ", is_following=" + is_following +
                ", is_pro_user=" + is_pro_user +
                ", medals=" + medals +
                '}';
    }
}
