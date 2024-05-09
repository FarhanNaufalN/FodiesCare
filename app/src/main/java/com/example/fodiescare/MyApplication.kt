package com.example.fodiescare
import android.app.Application
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatDelegate
import com.example.core.utils.DarkMode
import dagger.hilt.android.HiltAndroidApp
import java.util.*

@HiltAndroidApp
open class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        preferences.getString(
            getString(R.string.pref_key_dark),
            getString(R.string.pref_dark_follow_system)
        )?.apply {
            val mode = DarkMode.valueOf(this.uppercase(Locale.US))
            AppCompatDelegate.setDefaultNightMode(mode.value)
        }
    }
}