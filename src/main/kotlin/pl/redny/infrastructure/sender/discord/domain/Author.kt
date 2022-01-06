package pl.redny.infrastructure.sender.discord.domain

import com.fasterxml.jackson.annotation.JsonProperty

data class Author(
    @JsonProperty("name") val name: String,
    @JsonProperty("url") val url: String,
    @JsonProperty("icon_url") val iconUrl: String
)
