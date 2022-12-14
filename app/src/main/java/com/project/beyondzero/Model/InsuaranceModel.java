package com.project.beyondzero.Model;

public class InsuaranceModel {
    String patName;
    String patId;
    String patNo;

    public InsuaranceModel() {
    }

    public InsuaranceModel(String patName, String patId, String patNo) {
        this.patName = patName;
        this.patId = patId;
        this.patNo = patNo;
    }

    public String getPatName() {
        return patName;
    }

    public void setPatName(String patName) {
        this.patName = patName;
    }

    public String getPatId() {
        return patId;
    }

    public void setPatId(String patId) {
        this.patId = patId;
    }

    public String getPatNo() {
        return patNo;
    }

    public void setPatNo(String patNo) {
        this.patNo = patNo;
    }
}
