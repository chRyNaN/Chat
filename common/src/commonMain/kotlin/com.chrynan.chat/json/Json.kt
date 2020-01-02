package com.chrynan.chat.json

@Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY, AnnotationTarget.CONSTRUCTOR)
@Retention(AnnotationRetention.RUNTIME)
annotation class Json(
    /**
     * Used to map Kotlin properties and JSON fields that have different names.
     */
    val name: String = "",

    /**
     * If true, the property will be ignored by the Json Serializer.
     */
    val ignored: Boolean = false
)