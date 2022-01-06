package pl.redny.infrastructure.sender.discord.domain

import com.fasterxml.jackson.annotation.JsonProperty

data class Footer(@JsonProperty("text") val text: String, @JsonProperty("icon_url") val iconUrl: String)
