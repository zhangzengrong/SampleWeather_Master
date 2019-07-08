package com.example.administrator.myweather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.administrator.myweather.common.SpUtil;
import com.example.administrator.myweather.common.ToastUtil;
import com.example.administrator.myweather.common.User;
import com.example.administrator.myweather.greendao.UserDao;

import java.util.List;

/**
 * 作者：Rookie
 * 邮箱：1939428911.com
 * 注释：登录
 */
public class LoginActivity extends Activity implements View.OnClickListener {
    private EditText tvname, tvnum, tvpwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.btn_reg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);

            }
        });
        findViewById(R.id.btn_login).setOnClickListener(this);
        tvnum = (EditText) findViewById(R.id.tv_num);
        tvpwd = (EditText) findViewById(R.id.tv_password);
    }

    @Override
    public void onClick(View view) {
        //todo 登录做必要判断
        if (TextUtils.isEmpty(tvnum.getText().toString())) {
            ToastUtil.showShortToast(this, "手机号码不能为空!");
            return;
        }
        if (TextUtils.isEmpty(tvpwd.getText().toString())) {
            ToastUtil.showShortToast(this, "密码不能为空!");
            return;
        }
        User user = new User();
        user.pwd = tvpwd.getText().toString();
        user.mobile = tvnum.getText().toString();
//      TODO  数据库登录
        List<User> mList = MyAPP.getmDaoSession().getUserDao().queryBuilder()
                .where(UserDao.Properties.Mobile.eq(user.mobile),
                        UserDao.Properties.Pwd.eq(user.pwd))
                .list();
        if (mList.size() == 0) {
//            登录失败
            ToastUtil.showShortToast(this, "用户名或密码错误!");
            return;
        }else {
            //登陆成功
        SpUtil.put("userId", mList.get(0).getId() + "");
        SpUtil.put("isLogin", true);
            SpUtil.put("usertype", mList.get(0).major);
        Intent intent = new Intent(this, SpUtil.getBoolean("isLogin", false) ?MainActivity.class : LoginActivity.class);
        startActivity(intent);
        finish();
        }
    }
}