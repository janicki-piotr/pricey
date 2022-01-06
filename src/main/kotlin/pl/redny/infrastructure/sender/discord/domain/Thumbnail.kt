package pl.redny.infrastructure.sender.discord.domain

import com.fasterxml.jackson.annotation.JsonProperty

data class Thumbnail(@JsonProperty("url") val url: String)
