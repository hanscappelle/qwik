package be.hcpl.android.sportapp.ui

import android.content.Context
import androidx.annotation.StringRes

class Literals(
    val context: Context,
) {

    fun get(@StringRes key: Int) = context.getString(key)

}

