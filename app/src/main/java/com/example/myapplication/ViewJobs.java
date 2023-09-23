package com.example.myapplication;

public class ViewJobs {
    private String ems;
    private String type;
    private String danger;

    public ViewJobs(String ems, String type, String danger) {
        this.ems = ems;
        this.type = type;
        this.danger = danger;
    }

    public String getEms() {
        return ems;
    }

    public String getType() {
        return type;
    }

    public String getDanger() {
        return danger;
    }

    public void setEms(String ems) {
        this.ems = ems;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDanger(String danger) {
        this.danger = danger;
    }
}
