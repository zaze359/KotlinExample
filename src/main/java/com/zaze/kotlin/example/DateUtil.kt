package com.zaze.kotlin.example

import java.text.SimpleDateFormat
import java.util.*

object DateUtil {
    fun timeMillisToString(timeMillis: Long = System.currentTimeMillis(), pattern: String = "yyyy-MM-dd HH:mm:ss:SSS"): String {
        return SimpleDateFormat(pattern, Locale.getDefault()).apply {
            this.timeZone = timeZone
        }.format(Date(timeMillis))
    }
}