package ru.sr.mango_test_task.core.extension

import android.content.Context
import ru.sr.mango_test_task.app.MangoApp
import ru.sr.mango_test_task.di.AppComponent

fun Context.appComponent(): AppComponent =
    when (this) {
        is MangoApp -> appComponent
        else -> this.applicationContext.appComponent()
    }