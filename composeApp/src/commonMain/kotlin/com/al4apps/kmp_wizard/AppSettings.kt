package com.al4apps.kmp_wizard

import com.russhwolf.settings.Settings

interface AppSettings {
    var onbShowCount: Int
}

expect class AppSettingsFactory {
    fun create(): AppSettings
}

class AppSettingsImpl(
    private val settings: Settings
) : AppSettings {
    override var onbShowCount: Int
        get() = settings.getInt(KEY, 0)
        set(value) = settings.putInt(KEY, value)

    private companion object {
        const val KEY = "onb_show_count"
    }
}