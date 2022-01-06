package pl.redny.domain

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

interface DateTime {
    companion object {
        val FORMATTER_DD_MM_YYYY = "dd/MM/yyyy"
        val FORMATTER_DD_MM_YYYY_DASHES = "dd-MM-yyyy"
        val FORMATTER_DD_MM_YYYY_HH_MM_SS = "yyyy-MM-dd HH:mm:ss"
        val FORMATTER_HH_MM = "HH:mm"
        val FORMATTER_HH_MM_SS = "HH:mm:ss"
    }

    fun now(): LocalDateTime

    fun now(dateTimeFormat : String): String
}