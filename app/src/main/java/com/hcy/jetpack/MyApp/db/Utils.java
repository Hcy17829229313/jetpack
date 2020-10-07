package com.hcy.jetpack.MyApp.db;

import com.example.greendaodemo.db.CollectionBeanDao;
import com.example.greendaodemo.db.DaoSession;
import com.hcy.jetpack.MyApp.bean.CollectionBean;
import com.hcy.jetpack.app.MyApp;

import java.util.List;

public class Utils {


    private static DaoSession daoSession;

    public static void inster(CollectionBean collectionBean) {
        if (!querone(collectionBean)) {
            daoSession.insertOrReplace(collectionBean);
        }
    }

    public static void delete(CollectionBean collectionBean) {
        if (querone(collectionBean)) {
            daoSession.delete(collectionBean);
        }
    }

    public static List<CollectionBean> loadAll() {
        return daoSession.loadAll(CollectionBean.class);
    }

    public static boolean querone(CollectionBean collectionBean) {
        CollectionBean unique = daoSession.queryBuilder(CollectionBean.class).where(CollectionBeanDao.Properties.Id.eq(collectionBean.getId())).unique();

        return unique == null ? false : true;
    }
}
