package com.example.copengxiaolue.testapplication.module;

/**
 * Created by copengxiaolue on 2017/03/28.
 */

public class UserImp implements IUser {

    private String username;
    private String password;

    public UserImp(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean checkUserInfo(String username, String password) {
        return true;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
