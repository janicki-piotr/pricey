package pl.redny.infrastructure.sender.discord.builder

import pl.redny.domain.message.Message
import pl.redny.infrastructure.sender.discord.domain.Webhook

interface WebhookBuilder {

    fun build(message: Message): Webhook
}
