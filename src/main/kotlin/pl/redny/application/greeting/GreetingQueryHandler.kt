package pl.redny.application.greeting

import pl.redny.cqrs.query.Query
import pl.redny.cqrs.query.QueryHandler
import pl.redny.domain.DateTime
import pl.redny.infrastructure.quarkus.GreetingConfig
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class GreetingQueryHandler(private val greetingsConfig: GreetingConfig, private val dateTime: DateTime) :
    QueryHandler<GreetingQuery, String> {

    override fun execute(query: GreetingQuery): Result<String> {
        return Result.success(
            greetingsConfig.message().orEmpty() + dateTime.now(DateTime.FORMATTER_DD_MM_YYYY_HH_MM_SS)
        )
    }

    override fun canHandle(query: Query): Boolean = query is GreetingQuery
}
