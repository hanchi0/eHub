package com.jaemion.eHub.network.model;

import com.google.gson.annotations.SerializedName;

public class UserDataModel {
    @SerializedName("id")
    String user_id;
    @SerializedName("pw")
    String user_pw;
    @SerializedName("type")
    String user_type;
    @SerializedName("result")
    Integer result;

    public String getUserId() {
        return user_id;
    }

    public void setUserId(String id) {
        this.user_id = id;
    }

    public String getUserPw() {
        return user_pw;
    }

    public void setUserPw(String pw) {
        user_pw = pw;
    }

    public String getUserType() {
        return user_type;
    }

    public void setUserType(String type) {
        user_type = type;
    }

    public Integer getUserResult(){return result;}
    public void setResult(int result){this.result = result;}
}
