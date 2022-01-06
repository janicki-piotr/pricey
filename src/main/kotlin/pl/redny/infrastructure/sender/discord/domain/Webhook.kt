package pl.redny.infrastructure.sender.discord.domain

import com.fasterxml.jackson.annotation.JsonProperty

data class Webhook(
    @JsonProperty("username") val username: String,
    @JsonProperty("avatar_url") val avatarUrl: String,
    @JsonProperty("content") val content: String,
    @JsonProperty("embeds") val embeds: List<Embeds>
)
