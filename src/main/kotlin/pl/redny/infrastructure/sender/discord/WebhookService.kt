package pl.redny.infrastructure.sender.discord

import javax.ws.rs.*
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import pl.redny.infrastructure.sender.discord.domain.Webhook
import javax.ws.rs.core.Response

@RegisterRestClient(baseUri = "https://discord.com/api/webhooks")
interface WebhookService {

    @POST
    @Path("/{channelId}/{webhookToken}")
    fun sendMessage(
        @PathParam("channelId") channelId: String,
        @PathParam("webhookToken") webhookToken: String,
        payloadToSend: Webhook
    ): Response
}
