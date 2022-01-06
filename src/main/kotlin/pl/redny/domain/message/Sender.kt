package pl.redny.domain.message

interface Sender {

    fun send(message: Message, parameters: Map<String, Any>): Result<Unit>
}
