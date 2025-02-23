package be.hcpl.android.sportapp.domain.storage

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

interface Storage {

    fun get(key: String): String

    fun getString(key: String): String

    fun getBoolean(key: String): Boolean

    fun store(key: String, value: String)

    fun store(key: String, value: Boolean)
}

class LocalStorage(
    context: Context,
) : Storage {

    private var prefs: SharedPreferences = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)

    override fun get(key: String) = getString(key)

    override fun getString(key: String) = prefs.getString(key, "").toString()

    override fun store(key: String, value: String) = prefs.edit().putString(key, value).apply()

    override fun getBoolean(key: String) = prefs.getBoolean(key, false)

    override fun store(key: String, value: Boolean) = prefs.edit().putBoolean(key, value).apply()

    companion object {
        const val PREF_NAME = "local.storage"
    }
}