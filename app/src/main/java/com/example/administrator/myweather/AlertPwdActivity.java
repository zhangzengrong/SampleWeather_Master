package com.example.administrator.myweather;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.administrator.myweather.common.SpUtil;
import com.example.administrator.myweather.common.ToastUtil;
import com.example.administrator.myweather.common.User;
import com.example.administrator.myweather.greendao.UserDao;

/**
 * 作者：Rookie
 * 邮箱：1939428911.com
 * 注释：修改密码
 */
public class AlertPwdActivity extends Activity implements View.OnClickListener {
    private EditText tvnum,tvpwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alertpwd);
        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        findViewById(R.id.btn_login).setOnClickListener(this);
        tvnum=(EditText)findViewById(R.id.tv_num);
        tvpwd=(EditText)findViewById(R.id.tv_password);
    }

    @Override
    public void onClick(View view) {
        //Todo 修改密码
        if (TextUtils.isEmpty(tvnum.getText().toString())){
            ToastUtil.showShortToast(this,"旧密码不能为空!");
            return;
        }
        if (TextUtils.isEmpty(tvpwd.getText().toString())){
            ToastUtil.showShortToast(this,"新密码不能为空!");
            return;
        }
        //intent传值
            User user=MyAPP.getmDaoSession().getUserDao().queryBuilder().where(UserDao.Properties.Id.eq(SpUtil.getString("userId",""))).list().get(0);
          if (!user.pwd.equals(getIntent().getStringExtra("pwd"))){
              ToastUtil.showShortToast(this,"旧密码错误!");
              return;
          }
          else {
              user.pwd=tvpwd.getText().toString();

              ToastUtil.showShortToast(AlertPwdActivity.this,"密码修改成功!");
                     finish();
          }
        }

}