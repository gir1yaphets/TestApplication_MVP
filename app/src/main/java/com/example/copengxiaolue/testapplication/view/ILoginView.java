package com.example.copengxiaolue.testapplication.view;

/**
 * Created by copengxiaolue on 2017/03/28.
 */

public interface ILoginView {

    /**
     * Login开始
     */
    void onLoginStart();

    /**
     * Login成功
     */
    void onLoginSuccess();

    /**
     * Login失败
     */
    void onLoginFail();


    /**
     * 清除数据
     */
    void onClearView();
}
