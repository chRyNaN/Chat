package com.chrynan.chat.navigation.core

import android.os.Parcelable
import androidx.fragment.app.Fragment
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
class FragmentInfo private constructor(
    val className: String,
    val id: String
) : Parcelable {

    companion object {

        private const val SEPARATOR = "|"

        fun fromFragment(fragment: Fragment) =
            FragmentInfo(
                className = fragment::class.java.name,
                id = UUID.randomUUID().toString()
            )

        fun fromTag(tag: String) =
            FragmentInfo(
                className = tag.split(SEPARATOR).first(),
                id = tag.split(SEPARATOR)[1]
            )

        fun fromFragmentTag(fragment: Fragment): FragmentInfo {
            val tag = fragment.tag ?: throw IllegalArgumentException("Fragment must have tag.")

            return fromTag(tag = tag)
        }
    }

    fun asFragmentTag(): String = buildString {
        append(className)
        append(SEPARATOR)
        append(id)
    }
}