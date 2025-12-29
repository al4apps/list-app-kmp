package com.al4apps.kmp_wizard

import platform.Foundation.NSDate
import platform.Foundation.NSDateFormatter
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}
class IOSDateTime : DateTime {
    fun currentDateTime(): String {
        val date = NSDate()
        val formatter = NSDateFormatter()
        formatter.dateFormat = "yyyy-MM-dd HH:mm:ss"
        return formatter.stringFromDate(date)
    }
    override val dateTime = currentDateTime()

}

actual fun getPlatform(): Platform = IOSPlatform()
actual fun getDateTime(): DateTime = IOSDateTime()