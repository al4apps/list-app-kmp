package com.al4apps.listapp

import android.app.Application
import com.al4apps.kmp_wizard.AppSettings
import com.al4apps.kmp_wizard.AppSettingsFactory
// Используем AppSettings и AppSettingsFactory из общего KMP-модуля composeApp,
// чтобы не дублировать реализацию настроек в androidApp и переиспользовать общий код.

class ListApp : Application() {

    lateinit var appSettings: AppSettings

    override fun onCreate() {
        super.onCreate()
        appSettings = AppSettingsFactory(this).create()
    }
}