package com.chrynan.chat.utils

import com.chrynan.chat.model.InvalidUriException
import com.chrynan.chat.model.Uri
import com.chrynan.chat.model.uri

fun Uri.toAndroidUri() = android.net.Uri.fromParts(scheme, schemeSpecificPart, fragment)

fun android.net.Uri.toKotlinUri() = uri(
    scheme = scheme ?: throw InvalidUriException(message = "Invalid scheme: $scheme"),
    authority = authority,
    userInfo = userInfo,
    host = host,
    port = port,
    path = path ?: throw InvalidUriException(message = "Invalid path: $path"),
    query = query,
    fragment = fragment
)

fun android.net.Uri.toKotlinUriOrNull(): Uri? {
    val s = scheme
    val p = path

    if (s == null) return null
    if (p == null) return null

    return uri(
        scheme = s,
        authority = authority,
        userInfo = userInfo,
        host = host,
        port = port,
        path = p,
        query = query,
        fragment = fragment
    )
}