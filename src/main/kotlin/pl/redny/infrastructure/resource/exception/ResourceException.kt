package pl.redny.infrastructure.resource.exception

class ResourceException (message: String? = null, cause: Throwable? = null) : Exception(message, cause) {
    constructor(cause: Throwable) : this(null, cause)
}