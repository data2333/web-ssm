package com.heitian.ssm.model;

/**
 * Created by Administrator on 2017/11/5.
 */
public class SickContent {
    private Integer id;
    private String SicksName;
    private String contents;
    private String Symptom;
    private String Prevention;
    private String Cure;
    @Override
    public String toString() {
        return "SickContent{" +
                "SicksName='" + SicksName + '\'' +
                ", contents='" + contents + '\'' +
                ", Symptom='" + Symptom + '\'' +
                ", Prevention='" + Prevention + '\'' +
                ", Cure='" + Cure + '\'' +
                '}';
    }

    public String getSicksName() {
        return SicksName;
    }

    public void setSicksName(String sicksName) {
        SicksName = sicksName;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getSymptom() {
        return Symptom;
    }

    public void setSymptom(String symptom) {
        Symptom = symptom;
    }

    public String getPrevention() {
        return Prevention;
    }

    public void setPrevention(String prevention) {
        Prevention = prevention;
    }

    public String getCure() {
        return Cure;
    }

    public void setCure(String cure) {
        Cure = cure;
    }
}
