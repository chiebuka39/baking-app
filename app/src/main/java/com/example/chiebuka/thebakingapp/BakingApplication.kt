package com.example.chiebuka.thebakingapp

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration
import org.greenrobot.eventbus.EventBus

/**
 * Created by chiebuka on 6/16/17.
 */
class BakingApplication(): Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(applicationContext)
        val realmConfiguration = RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(realmConfiguration)


    }

    //val bus = EventBus()
}