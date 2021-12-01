package com.appp.nira

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NiraApp : Application() {

    companion object {
        private var appContext: Context? = null
        val getAppContext: Context
            get() = appContext!!
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
    }
}
