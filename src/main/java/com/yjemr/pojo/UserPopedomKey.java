package com.yjemr.pojo;

public class UserPopedomKey {
    private String userId;

    private String popedomType;

    private String popedomLevelCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getPopedomType() {
        return popedomType;
    }

    public void setPopedomType(String popedomType) {
        this.popedomType = popedomType == null ? null : popedomType.trim();
    }

    public String getPopedomLevelCode() {
        return popedomLevelCode;
    }

    public void setPopedomLevelCode(String popedomLevelCode) {
        this.popedomLevelCode = popedomLevelCode == null ? null : popedomLevelCode.trim();
    }
}