package pl.redny.application.greeting

import arrow.core.Either
import pl.redny.cqrs.query.Query
import pl.redny.cqrs.query.QueryHandler
import pl.redny.infrastructure.quarkus.GreetingConfig
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class GreetingQueryHandler(private val greetingsConfig: GreetingConfig) : QueryHandler<GreetingQuery, String> {

    override fun execute(query: GreetingQuery): Either<Exception, String> {
        return Either.Right(greetingsConfig.message().orEmpty())
    }

    override fun canHandle(query: Query): Boolean = query is GreetingQuery
}