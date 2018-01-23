package com.liqy.neihan.bean;

/**
 * Created by liqy on 2018/1/9.
 */

public class GroupData {
    public int type;
    public int display_time;
    public int online_time;
    public Group group;


    @Override
    public String toString() {
        return "GroupData{" +
                "type=" + type +
                ", display_time=" + display_time +
                ", online_time=" + online_time +
                ", group=" + group +
                '}';
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getDisplay_time() {
        return display_time;
    }

    public void setDisplay_time(int display_time) {
        this.display_time = display_time;
    }

    public int getOnline_time() {
        return online_time;
    }

    public void setOnline_time(int online_time) {
        this.online_time = online_time;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public GroupData(int type, int display_time, int online_time, Group group) {

        this.type = type;
        this.display_time = display_time;
        this.online_time = online_time;
        this.group = group;
    }
}
