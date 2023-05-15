package ru.sr.mango_test_task.root.core.extension

import android.content.Context
import ru.sr.mango_test_task.root.app.MangoApp
import ru.sr.mango_test_task.root.di.AppComponent

fun Context.appComponent(): AppComponent =
    when (this) {
        is MangoApp -> appComponent
        else -> this.applicationContext.appComponent()
    }