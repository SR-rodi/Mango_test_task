package ru.sr.mango_test_task.data.provider

import android.content.Context
import ru.sr.mango_test_task.domain.provider.TokenProvider

class TokenProviderImpl(context: Context):TokenProvider {

    private val preferenceToken =
        context.getSharedPreferences(TOKEN_SHARED_NAME, Context.MODE_PRIVATE)

    override fun putToken(token: String) {
        preferenceToken.edit().putString(TOKEN, token).apply()
    }

    override fun clearToken() {
        preferenceToken.edit().clear().apply()
    }

    override fun getToken(): String? =
        preferenceToken.getString(TOKEN, null)


    override fun tokenContain(): Boolean {
        return getToken() != null
    }

    companion object {
        private const val TOKEN_SHARED_NAME = "Pref_Token"
        private const val TOKEN = "token"
    }
}