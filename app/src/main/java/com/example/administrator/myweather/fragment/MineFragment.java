package com.example.administrator.myweather.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.administrator.myweather.AlertPwdActivity;
import com.example.administrator.myweather.LoginActivity;
import com.example.administrator.myweather.MyAPP;
import com.example.administrator.myweather.R;
import com.example.administrator.myweather.common.SpUtil;
import com.example.administrator.myweather.common.User;
import com.example.administrator.myweather.greendao.UserDao;

import java.io.File;
import java.util.List;

/**
 * 作者：Rookie
 * 邮箱：1939428911.com
 * 注释：
 */
public class MineFragment extends Fragment implements View.OnClickListener {
    private View view;
    private User user;


    @Override
    public void onResume() {
        super.onResume();
        query(false);
    }

    private TextView tvname;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_mine, container, false);
            tvname = (TextView) view.findViewById(R.id.tv_name);
            view.findViewById(R.id.btn_exit).setOnClickListener(this);
            view.findViewById(R.id.btn_alpwd).setOnClickListener(this);

            view.findViewById(R.id.btn_info).setOnClickListener(this);
        }
        return view;
    }


    /**
     * 查询统计的数据并显示UI
     *
     * @param sign
     */
    private void query(boolean sign) {
            user = MyAPP.getmDaoSession().getUserDao().queryBuilder().where(UserDao.Properties.Id.eq(SpUtil.getString("userId",""))).list().get(0);
            tvname.setText(user.name);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {


            case R.id.btn_alpwd:
                //修改密码
                Intent is = new Intent(getActivity(), AlertPwdActivity.class);
                is.putExtra("pwd",user.pwd);
                startActivity(is);

                break;
            case R.id.btn_exit:
                //Todo 退出登录
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setIcon(R.mipmap.ic_launcher_round);
                builder.setTitle("提示");
                builder.setMessage("确认退出登录吗？");
                builder.setCancelable(true);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SpUtil.put("isLogin", false);
                        Intent intent = new Intent(getContext(), LoginActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.create().show();
                break;

        }
    }


}
