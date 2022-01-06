package pl.redny.infrastructure.sender.discord

import org.eclipse.microprofile.rest.client.inject.RestClient
import pl.redny.domain.message.Message
import pl.redny.domain.message.Sender
import pl.redny.infrastructure.sender.discord.builder.WebhookBuilder
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class WebhookSender(@RestClient val webhookService: WebhookService, val webhookBuilder: WebhookBuilder) : Sender {

    companion object {
        const val CHANNEL_ID: String = "channelId"
        const val WEBHOOK_TOKEN: String = "webhookToken"
    }

    override fun send(message: Message, parameters: Map<String, Any>): Result<Unit> {
        return Result.runCatching {
            webhookService.sendMessage(
                parameters[CHANNEL_ID] as String, parameters[WEBHOOK_TOKEN] as String, webhookBuilder.build(message)
            )
        }
    }
}
