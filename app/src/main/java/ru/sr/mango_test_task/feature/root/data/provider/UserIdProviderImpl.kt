package ru.sr.mango_test_task.feature.root.data.provider

import android.content.Context
import ru.sr.mango_test_task.feature.root.domain.provider.UserIdProvider

class UserIdProviderImpl(context: Context) : UserIdProvider {
    private val preferenceUser =
        context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)

    override fun putUserId(id: String?) {
        preferenceUser.edit().putString(SHARED_KEY, id).apply()
    }

    override fun clearUserId() {
        preferenceUser.edit().clear().apply()
    }

    override fun getUserId(): String? {
        return preferenceUser.getString(SHARED_KEY, null)
    }


    private companion object {
        const val SHARED_NAME = "User_Id_shared"
        const val SHARED_KEY = "User_Id_key"
    }
}