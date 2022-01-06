package pl.redny.infrastructure.resource

import pl.redny.application.greeting.GreetingQuery
import pl.redny.cqrs.query.QueryDispatcher
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/hello")
class GreetingResource(var queryDispatcher : QueryDispatcher) {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = queryDispatcher.dispatchQuery(GreetingQuery())
}