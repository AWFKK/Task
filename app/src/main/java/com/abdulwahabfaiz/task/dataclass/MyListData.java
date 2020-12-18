package com.abdulwahabfaiz.task.dataclass;

public class MyListData {

    private String description;
    private int imgId;
    private String time;

    public MyListData(String description, int imgId, String time) {
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
