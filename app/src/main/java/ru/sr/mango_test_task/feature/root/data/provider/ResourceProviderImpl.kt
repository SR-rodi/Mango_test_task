package ru.sr.mango_test_task.feature.root.data.provider

import android.content.res.Resources
import ru.sr.mango_test_task.feature.root.domain.provider.ResourceProvider

class ResourceProviderImpl(private val resources: Resources) : ResourceProvider {

    override fun getString(id: Int) = resources.getString(id)
}