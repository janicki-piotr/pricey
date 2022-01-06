package pl.redny.domain.message

data class Message(val context: String, val title: String, val author: String, val more: Map<String, Any>)
