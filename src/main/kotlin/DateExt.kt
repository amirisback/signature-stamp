package io.github.amirisback

import java.text.SimpleDateFormat
import java.util.Date

const val ISO_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
const val DEFAULT_FORMAT = "dd LLLL yyyy"
const val DATE_TIME_FORMAT = "dd-MM-yyyy HH:mm:ss"
const val DATE_TIME_FORMAT_NO_SECOND = "dd-MM-yyyy HH:mm"
const val DATE_TIME_FORMAT_NO_SECOND_TEXT = "dd LLLL yyyy HH:mm"

const val DATE_MONTH = "dd LLL"

const val DATE_TIME_FORMAT_AM_PM = "dd MMMM yyyy, H.mm a"

const val SIMPLE_DATE_FORMAT = "dd-MM-yyyy"
const val SIMPLE_DATE_FORMAT_YEAR_FIRST = "yyyy-MM-dd"
const val SIMPLE_DATE_FORMAT_YEAR_FIRST_NO_SECOND = "yyyy-MM-dd HH:mm"
const val SIMPLE_DATE_FORMAT_REVERSE = "yyyyMMdd"

const val TIME_FORMAT = "HH:mm"
const val TIME_SECOND_FORMAT = "HH:mm:ss"
const val TIME_AM_PM_FORMAT = "H.mm a"

fun getDateTodayExt(format: String = DEFAULT_FORMAT): String {
    return SimpleDateFormat(format).format(Date())
}