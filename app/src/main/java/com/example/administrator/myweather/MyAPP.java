package com.example.administrator.myweather;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.administrator.myweather.greendao.DaoMaster;
import com.example.administrator.myweather.greendao.DaoSession;
import com.lzy.okgo.OkGo;

/**
 * Created by Administrator on 2019/4/11.
 */

public class MyAPP extends Application {
    private static MyAPP mApplication;

    public static final String DB_NAME = "app.db";
    private static DaoSession mDaoSession;
    public static MyAPP getContext() {
        return mApplication;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        //必须调用初始化
        mApplication=this;
        OkGo.init(this);
        initGreenDao();
}
    private void initGreenDao() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, DB_NAME);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        mDaoSession = daoMaster.newSession();
    }

    public static DaoSession getmDaoSession() {
        return mDaoSession;
    }

}
