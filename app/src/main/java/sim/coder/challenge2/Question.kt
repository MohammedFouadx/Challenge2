package sim.coder.challenge2

import androidx.annotation.StringRes

data class Question (
    @StringRes val textResId: Int,
    val answer: Boolean
)
