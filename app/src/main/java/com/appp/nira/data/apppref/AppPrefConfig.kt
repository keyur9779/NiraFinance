package com.appp.nira.data.apppref

import android.content.Context
import android.content.SharedPreferences
import com.appp.nira.NiraApp
import com.appp.nira.utils.Constant.PREF
import timber.log.Timber

/**
 * Global class used to save application state into shared pref;
 * object shoud be singleton class created from application class
 *
 * @author keyur thumar
 */
class AppPrefConfig private constructor() {
    private lateinit var preference: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    private val USER_SESSION = "session"

    var isValidSession: Boolean
        get() {
            return preference.getBoolean(USER_SESSION, true)
        }
        set(data) {
            editor.putBoolean(USER_SESSION, data)
            editor.commit()
        }


    companion object {
        private var appConfig: AppPrefConfig? = null
        val pref: AppPrefConfig
            get() {
                if (appConfig == null) {
                    appConfig =
                        AppPrefConfig()
                }
                return appConfig!!
            }
    }

    private fun openPref() {

        preference = NiraApp.getAppContext.getSharedPreferences(
            PREF,
            Context.MODE_PRIVATE
        )
        editor = preference.edit()

    }

    /**
     * AppConfig is used for initialising shared preferences object for entire application.
     * it will store state of application like registration,device tokenId, phone number etc.
     */
    init {
        openPref()
        Timber.d("app config class initialized")
    }
}
