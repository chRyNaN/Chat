package com.chrynan.chat.utils

import com.chrynan.chat.R
import com.chrynan.chat.feature.reaction.model.ColorInt
import com.chrynan.chat.resources.ResourceAccessor
import com.chrynan.chat.resources.ResourceProvider
import javax.inject.Inject

class UserColorProvider @Inject constructor(private val resourceProvider: ResourceProvider) :
    ResourceAccessor by resourceProvider {

    // Note: Not using the first two accent colors because those are used for the offline/online badges and
    // would conflict. Also, these need to be updated to support enough contrasting TODO
    private val accentThreeColor by color(R.color.accent_three_color)
    private val accentFourColor by color(R.color.accent_four_color)
    private val accentFiveColor by color(R.color.accent_five_color)
    private val accentSixColor by color(R.color.accent_six_color)

    private val colors by lazy {
        listOf(
            accentThreeColor,
            accentFourColor,
            accentFiveColor,
            accentSixColor
        )
    }

    private val userColorMap = mutableMapOf<String, ColorInt>()

    fun getColorFor(name: String): ColorInt {
        val color = userColorMap[name] ?: colors[userColorMap.size % colors.size]

        userColorMap[name] = color

        return color
    }
}