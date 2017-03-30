package com.example.copengxiaolue.testapplication;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.copengxiaolue.testapplication.presenter.ILoginPresenter;
import com.example.copengxiaolue.testapplication.presenter.LoginPresenterImp;
import com.example.copengxiaolue.testapplication.view.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {

    private DrawerLayout mDrawerLayout;
    private EditText mUserName;
    private EditText mPassword;
    private Button mLogin;
    private Button mClear;
    private ProgressBar mProgressBar;

    private ILoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        initView();
    }

    private void initView() {
        mUserName = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);
        mLogin = (Button) findViewById(R.id.login);
        mClear = (Button) findViewById(R.id.clear);
        mProgressBar = (ProgressBar) findViewById(R.id.progressbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mLoginPresenter = new LoginPresenterImp(this);

        mLogin.setOnClickListener(this);
        mClear.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
                mDrawerLayout.closeDrawer(Gravity.LEFT);
            } else {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                String username = mUserName.getText().toString();
                String password = mPassword.getText().toString();
                mLoginPresenter.onLogin(username, password);
                break;
            case R.id.clear:
                mLoginPresenter.onClear();
                break;
            default:
                break;
        }
    }

    @Override
    public void onLoginStart() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onLoginSuccess() {
        mProgressBar.setVisibility(View.GONE);
        Toast.makeText(this, R.string.login_success, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFail() {
        mProgressBar.setVisibility(View.GONE);
        Toast.makeText(this, R.string.login_fail, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClearView() {
        mUserName.setText("");
        mPassword.setText("");
    }
}
