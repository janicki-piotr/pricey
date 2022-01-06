package pl.redny.application.discord

import pl.redny.cqrs.command.Command
import pl.redny.domain.message.Message

data class DiscordMessageCommand(val message: Message, val channelId: String, val webhookToken: String) : Command
