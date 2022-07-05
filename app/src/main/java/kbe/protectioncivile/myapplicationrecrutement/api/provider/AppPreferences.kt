package kbe.protectioncivile.myapplicationrecrutement.api.provider

import android.content.Context
import android.content.SharedPreferences

object AppPreferences {
    private const val NAME = "Recrutement"
    private const val MODE = Context.MODE_PRIVATE
    lateinit var preferences: SharedPreferences

    //SharedPreferences variables
    private val IS_LOGIN = Pair("is_login", false)
    private val ID = Pair("id", "")
    private val TOKEN = Pair("token", "")
    private val EMAIL = Pair("email", "")
    private val USERNAME = Pair("UserName", "")
    private val USERLASTNAME = Pair("USERLASTNAME", "")
    private val ROLE = Pair("ROLE", "")


    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    //an inline function to put variable and save it
    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    //SharedPreferences variables getters/setters
    var isLogin: Boolean
        get() = preferences.getBoolean(IS_LOGIN.first, IS_LOGIN.second)
        set(value) = preferences.edit {
            it.putBoolean(IS_LOGIN.first, value)
        }

    var Userid: String
        get() {
            // strips off all non-ASCII characters
            var text = preferences.getString(ID.first, ID.second) ?: ""
            text = text.replace("[^\\x00-\\x7F]".toRegex(), "")

            // erases all the ASCII control characters
            text = text.replace("[\\p{Cntrl}&&[^\r\n\t]]".toRegex(), "")
            text = text.replace("[\"+]".toRegex(), replacement = "")
            // removes non-printable characters from Unicode
            text = text.replace("\\p{C}".toRegex(), "")
            return text.trim()

        }
        set(value) = preferences.edit {
            it.putString(ID.first, value)
        }

    var Token: String
        get() = preferences.getString(TOKEN.first, TOKEN.second) ?: ""
        set(value) = preferences.edit {
            it.putString(TOKEN.first, value)
        }
    var Role: String
        get() = preferences.getString(ROLE.first, ROLE.second) ?: ""
        set(value) = preferences.edit {
            it.putString(ROLE.first, value)
        }
    var Username: String
        get() = preferences.getString(USERNAME.first, USERNAME.second) ?: ""
        set(value) = preferences.edit {
            it.putString(USERNAME.first, value)

        }

    var UserLastname: String
        get() = preferences.getString(USERLASTNAME.first, USERLASTNAME.second) ?: ""
        set(value) = preferences.edit {
            it.putString(USERLASTNAME.first, value)

        }

    var email: String
        get() = preferences.getString(EMAIL.first, EMAIL.second) ?: ""
        set(value) = preferences.edit {
            it.putString(EMAIL.first, value)
        }

    fun clear(key: String) {
        preferences.edit().remove(key).apply()
    }
}