package com.example.fyp_2022;

public class AdddataUserClass {

    String pulserate, weight, height, bodytemp, bloodtemp, sugarlevel;

    public AdddataUserClass() {

    }

    public AdddataUserClass(String pulserate, String weight, String height, String bodytemp, String bloodtemp, String sugarlevel) {
        this.pulserate = pulserate;
        this.weight = weight;
        this.height = height;
        this.bodytemp = bodytemp;
        this.bloodtemp = bloodtemp;
        this.sugarlevel = sugarlevel;
    }

    public String getPulserate() {
        return pulserate;
    }

    public void setPulserate(String pulserate) {
        this.pulserate = pulserate;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getBodytemp() {
        return bodytemp;
    }

    public void setBodytemp(String bodytemp) {
        this.bodytemp = bodytemp;
    }

    public String getBloodtemp() {
        return bloodtemp;
    }

    public void setBloodtemp(String bloodtemp) {
        this.bloodtemp = bloodtemp;
    }

    public String getSugarlevel() {
        return sugarlevel;
    }

    public void setSugarlevel(String sugarlevel) {
        this.sugarlevel = sugarlevel;
    }
}
