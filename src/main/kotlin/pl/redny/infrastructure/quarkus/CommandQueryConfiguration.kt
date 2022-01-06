package pl.redny.infrastructure.quarkus

import pl.redny.cqrs.DefaultDispatcher
import pl.redny.cqrs.command.Command
import pl.redny.cqrs.command.CommandHandler
import pl.redny.cqrs.query.Query
import pl.redny.cqrs.query.QueryHandler
import javax.enterprise.context.Dependent
import javax.enterprise.inject.Instance
import javax.enterprise.inject.Produces
import javax.inject.Inject

@Dependent
class CommandQueryConfiguration {

    @Inject
    lateinit var commandHandlers: Instance<CommandHandler<*>>

    @Inject
    lateinit var queryHandlers: Instance<QueryHandler<*, *>>

    @Produces
    fun defaultDispatcher(
    ): DefaultDispatcher {
        return DefaultDispatcher(
            commandHandlers.toList() as List<CommandHandler<Command>>,
            queryHandlers.toList() as List<QueryHandler<Query, *>>
        )
    }
}
