package pl.redny.infrastructure.resource.exception

import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

@Provider
class ResourceExceptionMapper : ExceptionMapper<ResourceException> {
    override fun toResponse(exception: ResourceException?): Response {
        return Response.status(441).entity(exception?.message).build()
    }
}
