package com.yjemr.pojo;

public class UserPopedom extends UserPopedomKey {
    private String popedomLevel;

    public String getPopedomLevel() {
        return popedomLevel;
    }

    public void setPopedomLevel(String popedomLevel) {
        this.popedomLevel = popedomLevel == null ? null : popedomLevel.trim();
    }
}