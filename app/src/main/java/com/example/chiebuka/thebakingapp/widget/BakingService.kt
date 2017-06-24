package com.example.chiebuka.thebakingapp.widget

import android.app.IntentService
import android.content.Intent
import android.widget.RemoteViewsService

/**
 * Created by chiebuka on 6/23/17.
 */
class BakingService : RemoteViewsService() {

    override fun onGetViewFactory(intent: Intent?): RemoteViewsFactory {
       return WidgetDataProvider(this, intent!!)
    }


}