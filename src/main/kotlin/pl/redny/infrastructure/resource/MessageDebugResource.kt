package pl.redny.infrastructure.resource

import pl.redny.application.discord.DiscordMessageCommand
import pl.redny.cqrs.command.CommandDispatcher
import pl.redny.cqrs.command.CommandHandler
import pl.redny.domain.message.Message
import pl.redny.infrastructure.resource.exception.ResourceException
import pl.redny.infrastructure.sender.discord.WebhookSender
import javax.ws.rs.POST
import javax.ws.rs.Path

@Path("/debug/message")
class MessageDebugResource(val commandDispatcher: CommandDispatcher) {

    data class DiscordBody(val message: Message, val channelId: String, val webhookToken: String)

    @POST
    @Path("/discord")
    fun sendDiscordMessage(payload: DiscordBody) {
        val result = commandDispatcher.dispatchCommand(
            DiscordMessageCommand(
                payload.message, payload.channelId, payload.webhookToken
            )
        )

        if (result.isFailure) {
            throw ResourceException(result.exceptionOrNull()!!)
        }
    }
}