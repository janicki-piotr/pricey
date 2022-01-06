package pl.redny.infrastructure.sender.discord.domain

import com.fasterxml.jackson.annotation.JsonProperty

data class Field(
    @JsonProperty("name") val name: String,
    @JsonProperty("value") val value: String,
    @JsonProperty("inline") val inline: Boolean
)
