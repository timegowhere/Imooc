package com.skybatua.recyclerviewdemo.model;

/**
 * Created by q6593 on 2016/11/8.
 */

public class DemoModel {
    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;
    public int type;
    public int avatarColor;
    public String name;
    public String content;
    public int contentColor;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAvatarColor() {
        return avatarColor;
    }

    public void setAvatarColor(int avatarColor) {
        this.avatarColor = avatarColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getContentColor() {
        return contentColor;
    }

    public void setContentColor(int contentColor) {
        this.contentColor = contentColor;
    }

    @Override
    public String toString() {
        return "DemoModel{" +
                "type=" + type +
                ", avatarColor=" + avatarColor +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", contentColor=" + contentColor +
                '}';
    }
}
