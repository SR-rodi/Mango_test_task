package ru.sr.mango_test_task.feature.root.data.provider

import android.content.Context
import ru.sr.mango_test_task.feature.root.domain.provider.AccessTokenProvider
import ru.sr.mango_test_task.feature.root.domain.provider.RefreshTokenProvider

class TokenProviderImpl(
    context: Context,
    sharedName: String,
    private val key: String,
) : RefreshTokenProvider, AccessTokenProvider {

    private val preferenceToken =
        context.getSharedPreferences(sharedName, Context.MODE_PRIVATE)

    override fun putToken(token: String?) {
        preferenceToken.edit().putString(key, token).apply()
    }

    override fun clearToken() {
        preferenceToken.edit().clear().apply()
    }

    override fun getToken(): String? =
        preferenceToken.getString(key, null)


    override fun tokenContain(): Boolean {
        return getToken() != null
    }
}