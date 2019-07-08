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

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：Rookie
 * 邮箱：1939428911.com
 * 注释：注册
 */
public class RegisterActivity extends Activity implements View.OnClickListener {
    @BindView(R.id.tv_shenfen)
    EditText tvShenfen;
    private EditText tvname, tvnum, tvpwd, tvmajor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        ButterKnife.bind(this);
        findViewById(R.id.btn_reg).setOnClickListener(this);
        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tvnum = (EditText) findViewById(R.id.tv_num);
        tvname = (EditText) findViewById(R.id.tv_name);
        tvpwd = (EditText) findViewById(R.id.tv_password);
    }

    @Override
    public void onClick(View view) {
        if (TextUtils.isEmpty(tvname.getText().toString())) {
            ToastUtil.showShortToast(this, "名字不能为空!");
            return;
        }
        if (TextUtils.isEmpty(tvnum.getText().toString())) {
            ToastUtil.showShortToast(this, "手机号码不能为空!");
            return;
        }

        if (TextUtils.isEmpty(tvpwd.getText().toString())) {
            ToastUtil.showShortToast(this, "密码不能为空!");
            return;
        }
        User user = new User();
        user.name = tvname.getText().toString();
        user.pwd = tvpwd.getText().toString();
        user.mobile = tvnum.getText().toString();
        if (TextUtils.isEmpty(tvShenfen.getText().toString())||!tvShenfen.getText().toString().equals("管理员")){
        }else {
            user.major="管理员";
        }
        MyAPP.getmDaoSession().getUserDao().save(user);
        ToastUtil.showShortToast(this, "注册成功!");
        List<User> mList = MyAPP.getmDaoSession().getUserDao().queryBuilder()
                .where(UserDao.Properties.Mobile.eq(user.mobile), UserDao.Properties.Pwd.eq(user.pwd))
                .list();
        if (mList.size() != 0) {
            SpUtil.put("userId", mList.get(0).getId() + "");
            SpUtil.put("isLogin", true);
            SpUtil.put("usertype", user.major);
            Intent intent = new Intent(this, SpUtil.getBoolean("isLogin", false) ? MainActivity.class : LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
