package com.chrynan.chat.model

interface Uri {

    val scheme: String
    val authority: String?
    val userInfo: String?
    val host: String?
    val port: Int?
    val path: String
    val query: String?
    val fragment: String?
    val schemeSpecificPart: String
}

internal data class SimpleUri(
    override val scheme: String,
    override val authority: String? = null,
    override val userInfo: String? = null,
    override val host: String? = null,
    override val port: Int? = null,
    override val path: String,
    override val query: String? = null,
    override val fragment: String? = null
) : Uri {

    override val schemeSpecificPart: String
        get() = buildString {
            authority?.let(::append)
            append(path)
            query?.let(::append)
        }
}

fun uri(
    scheme: String,
    authority: String? = null,
    userInfo: String? = null,
    host: String? = null,
    port: Int? = null,
    path: String,
    query: String? = null,
    fragment: String? = null
): Uri = SimpleUri(
    scheme = scheme,
    authority = authority,
    userInfo = userInfo,
    host = host,
    port = port,
    path = path,
    query = query,
    fragment = fragment
)

data class InvalidUriException(override val message: String? = null) :
    RuntimeException("Invalid Uri: message = $message")