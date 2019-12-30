package com.chrynan.chat.resources

import com.chrynan.chat.R
import com.chrynan.chat.di.Inject

class ColorProvider @Inject constructor(private val resourceAccessor: ResourceAccessor) :
    ResourceAccessor by resourceAccessor,
    Colors {

    override val primary by color(R.color.primary_color)

    override val primaryLight by color(R.color.primary_light_color)

    override val primaryDark by color(R.color.primary_dark_color)

    override val accentPrimary by color(R.color.colorAccent)

    override val accentOne by color(R.color.accent_one_color)

    override val accentTwo by color(R.color.accent_two_color)

    override val accentThree by color(R.color.accent_three_color)

    override val accentFour by color(R.color.accent_four_color)

    override val accentFive by color(R.color.accent_five_color)

    override val accentSix by color(R.color.accent_six_color)

    override val error by color(R.color.error_color)

    override val white by color(R.color.white)

    override val black by color(R.color.black)

    override val offWhite by color(R.color.off_white_color)

    override val textDark by color(R.color.text_primary_color)

    override val textDarkSecondary by color(R.color.text_primary_subtle_color)

    override val textLight by color(R.color.text_secondary_color)

    override val textLightSecondary by color(R.color.text_secondary_subtle_color)

    override val textError by color(R.color.text_error_color)

    override val textAccent by color(R.color.text_accent_color)
}