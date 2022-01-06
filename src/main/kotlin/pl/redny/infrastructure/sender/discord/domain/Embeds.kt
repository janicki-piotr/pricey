package pl.redny.infrastructure.sender.discord.domain

import com.fasterxml.jackson.annotation.JsonProperty

data class Embeds(
    @JsonProperty("author") val author: Author,
    @JsonProperty("title") val title: String,
    @JsonProperty("url") val url: String,
    @JsonProperty("description") val description: String,
    @JsonProperty("color") val color: Int,
    @JsonProperty("fields") val fields: List<Field>,
    @JsonProperty("thumbnail") val thumbnail: Thumbnail,
    @JsonProperty("image") val image: Image,
    @JsonProperty("footer") val footer: Footer
)
