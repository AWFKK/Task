package com.abdulwahabfaiz.task.dataclass;

public class MyListData {

    private String description;
    private int imgId;
    private long time;

    public MyListData(String description, int imgId, long time) {
        this.description = description;
        this.imgId = imgId;
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
