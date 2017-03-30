package com.example.copengxiaolue.testapplication.presenter;

import android.os.Handler;
import android.os.Message;

import com.example.copengxiaolue.testapplication.module.IUser;
import com.example.copengxiaolue.testapplication.module.UserImp;
import com.example.copengxiaolue.testapplication.view.ILoginView;

/**
 * Created by copengxiaolue on 2017/03/28.
 */

public class LoginPresenterImp implements ILoginPresenter {

    private ILoginView mLoginView;
    private LoginHandler mHandler;

    private static final int LOGIN_SUCCESS = 1;
    private static final int LOGIN_FAIL = 2;

    public LoginPresenterImp(ILoginView mLoginView) {
        this.mLoginView = mLoginView;
        mHandler = new LoginHandler();
    }

    @Override
    public void onLogin(final String username, final String password) {
        mLoginView.onLoginStart();
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                IUser user = new UserImp(username, password);

                Message message = new Message();
                if (user.checkUserInfo(username, password)) {
                    message.what = LOGIN_SUCCESS;
                } else {
                    message.what = LOGIN_FAIL;
                }
                mHandler.sendMessage(message);
            }
        }.start();
    }

    @Override
    public void onClear() {
        mLoginView.onClearView();
    }

    class LoginHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case LOGIN_SUCCESS:
                    mLoginView.onLoginSuccess();
                    break;
                case LOGIN_FAIL:
                    mLoginView.onLoginFail();
                    break;
                default:
                    break;
            }
        }
    }
}
