package com.example.administrator.myweather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.administrator.myweather.common.SpUtil;


/**
 * 欢迎页面
 */
public class WelcomeActivity extends Activity {
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*如果不是第一次启动app，则启动页*/
        setContentView(R.layout.activity_welcome);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /*1.5秒后进入主页*/
                enterHomeActivity();
            }
        },1500);
    }
    private void enterHomeActivity(){
        //TODO 判断是否登录去主页
        Intent intent = new Intent(this, SpUtil.getBoolean("isLogin", false) ? MainActivity.class : LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
