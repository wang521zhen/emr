package com.yjemr.pojo;

public class UserInfo {
    private String userId;

    private String userName;

    private String password;

    private String enabled;

    private String effTime;

    private String expiTime;

    private String hospitalCode;

    private String dutyId;

    private String dutyName;

    private String adminLevels;

    private String adminLevelsCode;

    private String py;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled == null ? null : enabled.trim();
    }

    public String getEffTime() {
        return effTime;
    }

    public void setEffTime(String effTime) {
        this.effTime = effTime == null ? null : effTime.trim();
    }

    public String getExpiTime() {
        return expiTime;
    }

    public void setExpiTime(String expiTime) {
        this.expiTime = expiTime == null ? null : expiTime.trim();
    }

    public String getHospitalCode() {
        return hospitalCode;
    }

    public void setHospitalCode(String hospitalCode) {
        this.hospitalCode = hospitalCode == null ? null : hospitalCode.trim();
    }

    public String getDutyId() {
        return dutyId;
    }

    public void setDutyId(String dutyId) {
        this.dutyId = dutyId == null ? null : dutyId.trim();
    }

    public String getDutyName() {
        return dutyName;
    }

    public void setDutyName(String dutyName) {
        this.dutyName = dutyName == null ? null : dutyName.trim();
    }

    public String getAdminLevels() {
        return adminLevels;
    }

    public void setAdminLevels(String adminLevels) {
        this.adminLevels = adminLevels == null ? null : adminLevels.trim();
    }

    public String getAdminLevelsCode() {
        return adminLevelsCode;
    }

    public void setAdminLevelsCode(String adminLevelsCode) {
        this.adminLevelsCode = adminLevelsCode == null ? null : adminLevelsCode.trim();
    }

    public String getPy() {
        return py;
    }

    public void setPy(String py) {
        this.py = py == null ? null : py.trim();
    }
}