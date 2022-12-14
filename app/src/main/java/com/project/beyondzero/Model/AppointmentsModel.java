package com.project.beyondzero.Model;

public class AppointmentsModel {
    String AppointmentDate;
    String DoctorName;
    String DoctorTitle;
    String DoctorPhone;
    String AppointmentTime;
    String PatPhone;
    String PatName;

    public AppointmentsModel() {
    }

    public AppointmentsModel(String appointmentDate, String doctorName, String doctorTitle, String doctorPhone, String appointmentTime, String patPhone, String patName) {
        AppointmentDate = appointmentDate;
        DoctorName = doctorName;
        DoctorTitle = doctorTitle;
        DoctorPhone = doctorPhone;
        AppointmentTime = appointmentTime;
        PatPhone = patPhone;
        PatName = patName;
    }

    public String getAppointmentDate() {
        return AppointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        AppointmentDate = appointmentDate;
    }

    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String doctorName) {
        DoctorName = doctorName;
    }

    public String getDoctorTitle() {
        return DoctorTitle;
    }

    public void setDoctorTitle(String doctorTitle) {
        DoctorTitle = doctorTitle;
    }

    public String getDoctorPhone() {
        return DoctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        DoctorPhone = doctorPhone;
    }

    public String getAppointmentTime() {
        return AppointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        AppointmentTime = appointmentTime;
    }

    public String getPatPhone() {
        return PatPhone;
    }

    public void setPatPhone(String patPhone) {
        PatPhone = patPhone;
    }

    public String getPatName() {
        return PatName;
    }

    public void setPatName(String patName) {
        PatName = patName;
    }
}
