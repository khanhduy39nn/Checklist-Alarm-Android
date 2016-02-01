package com.ander39n.checklistalarm;

/**
 * Created by duynguyen on 1/29/2016.
 */
public class Alarm {
    private String time;
    private String title;
    private String repeat;
    private String grub;
    private int colorID;
    private boolean enable;
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRepeat() {
        return repeat;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }

    public Alarm(String title, String time, String grub, String repeat, int colorID, boolean enable) {
        this.title= title;
        this.time=time;
        this.grub=grub;
        this.repeat=repeat;
        this.colorID=colorID;
        this.enable=enable;
    }

    public Alarm() {
        // TODO Auto-generated constructor stub
    }

    public String getGrub() {
        return grub;
    }

    public void setGrub(String grub) {
        this.grub = grub;
    }

    public int getColorID() {
        return colorID;
    }

    public void setColorID(int colorID) {
        this.colorID = colorID;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
