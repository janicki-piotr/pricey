package pl.redny.infrastructure

import pl.redny.domain.DateTime
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class LocalDateTimeService : DateTime {

    override fun now(): LocalDateTime = LocalDateTime.now()

    override fun now(dateTimeFormat: String): String = now().format(DateTimeFormatter.ofPattern(dateTimeFormat))
}
