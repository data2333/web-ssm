package com.heitian.ssm.model;

/**
 * Created by Administrator on 2017/11/19.
 */
public class Parts {
    Integer id;
    private String partName;
    private String SicksName;
    private String contents;
    private String Reason;
    private String Prevention;
    private String Diagnostic;

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
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

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public String getPrevention() {
        return Prevention;
    }

    public void setPrevention(String prevention) {
        Prevention = prevention;
    }

    public String getDiagnostic() {
        return Diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        Diagnostic = diagnostic;
    }
}
