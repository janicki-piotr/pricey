package pl.redny.infrastructure.sender.discord.builder

import pl.redny.domain.message.Message
import pl.redny.infrastructure.sender.discord.domain.Webhook
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class DefaultBuilder : WebhookBuilder {

    override fun build(message: Message): Webhook {
        return buildWebhook(message)
    }

    private fun buildWebhook(message: Message): Webhook {
        return Webhook(message.author, message.more["image"].toString(), message.context, listOf())
    }
}
