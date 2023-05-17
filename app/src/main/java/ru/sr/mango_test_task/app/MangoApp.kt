package ru.sr.mango_test_task.app

import android.app.Application
import ru.sr.mango_test_task.di.AppComponent
import ru.sr.mango_test_task.di.DaggerAppComponent

class MangoApp : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().context(this).build()
    }
}

