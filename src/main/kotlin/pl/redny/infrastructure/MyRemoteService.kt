package pl.redny.infrastructure

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.QueryParam

@RegisterRestClient(baseUri = "https://stage.code.quarkus.io/api")
interface MyRemoteService {

    @GET
    @Path("/extensions")
    fun getExtensionsById(@QueryParam("id") id: String): Set<Extension>

    data class Extension(val id: String, val name: String, val shortName: String, val keywords: List<String>)
}
