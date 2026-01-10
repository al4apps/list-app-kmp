package com.al4apps.kmp_wizard

import android.app.Application

class ListApp : Application() {

    lateinit var appSettings: AppSettings

    override fun onCreate() {
        super.onCreate()
        appSettings = AppSettingsFactory(this).create()
    }
}