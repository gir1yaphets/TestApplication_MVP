package com.example.copengxiaolue.testapplication.presenter;

/**
 * Created by copengxiaolue on 2017/03/28.
 */

public interface ILoginPresenter {

    /**
     * 登录处理
     * @param username
     * @param password
     */
    void onLogin(String username, String password);

    /**
     *清除处理
     */
    void onClear();
}
