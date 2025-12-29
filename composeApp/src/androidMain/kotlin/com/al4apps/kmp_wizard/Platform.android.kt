package com.al4apps.kmp_wizard

import android.os.Build
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}
class AndroidDateTime : DateTime {
    fun getDt(): String {
        val curDt = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")
        return curDt.format(formatter)
    }
    override val dateTime: String
        get() = getDt()
}

actual fun getPlatform(): Platform = AndroidPlatform()
actual fun getDateTime(): DateTime = AndroidDateTime()