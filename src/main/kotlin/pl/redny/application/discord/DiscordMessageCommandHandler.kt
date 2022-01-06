package pl.redny.application.discord

import pl.redny.cqrs.command.Command
import pl.redny.cqrs.command.CommandHandler
import pl.redny.infrastructure.sender.discord.WebhookSender
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class DiscordMessageCommandHandler(val webhookSender: WebhookSender) : CommandHandler<DiscordMessageCommand> {
    override fun canHandle(command: Command): Boolean = command is DiscordMessageCommand

    override fun execute(command: DiscordMessageCommand): Result<Unit> {
        return webhookSender.send(
            command.message, mapOf("channelId" to command.channelId, "webhookToken" to command.webhookToken)
        )
    }
}