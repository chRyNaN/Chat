package com.chrynan.chat.delegates

import android.widget.TextView
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class TextViewTextDelegate(private val initializer: () -> TextView?) :
    ReadWriteProperty<Any, String> {

    private var textView: TextView? = null

    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        if (textView == null) {
            textView = initializer.invoke()
        }

        return textView?.text?.toString() ?: ""
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        if (textView == null) {
            textView = initializer.invoke()
        }

        textView?.text = value
    }
}

fun textView(initializer: () -> TextView) = TextViewTextDelegate(initializer)