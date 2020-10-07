package com.hcy.jetpack.app;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.greendaodemo.db.DaoMaster;
import com.example.greendaodemo.db.DaoSession;
import com.hcy.httplibrary.HttpConstant;
import com.hcy.httplibrary.HttpGlobalConfig;
import com.umeng.commonsdk.UMConfigure;

public class MyApp extends Application {
    private static MyApp sInstance;
    private DaoMaster.DevOpenHelper mHelper;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        setDatabase();


        HttpGlobalConfig.getInsance()
                .setBaseUrl("http://123.56.232.18:8080/")
                .setTimeout(HttpConstant.TIME_OUT)
                .setShowLog(true)
                .setTimeUnit(HttpConstant.TIME_UNIT)
                .initReady(this);

        initQQ();
    }

    /*private void initdb() {

        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "attion.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }*/
    private void setDatabase() {
        //通过DaoMaster内部类DevOpenHelper可以获取一个SQLiteOpenHelper 对象
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        // 此处MyDb表示数据库名称 可以任意填写
        mHelper = new DaoMaster.DevOpenHelper(this, "MyDb", null);    // MyDb是数据库的名字，更具自己的情况修改
        SQLiteDatabase db = mHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }
    public static MyApp getInstance(){
        return sInstance;
    }
    public DaoSession getDaoSession(){
        return mDaoSession;
    }


    private void initQQ() {
        UMConfigure.init(this,"5f447b61113468235fdc455c"
                ,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");//58edcfeb310c93091c000be2 5965ee00734be40b580001a0

    }
}
