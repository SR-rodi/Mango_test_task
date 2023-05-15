package ru.sr.mango_test_task.root.app

import android.app.Application
import android.content.Context
import ru.sr.mango_test_task.root.di.AppComponent
import ru.sr.mango_test_task.root.di.DaggerAppComponent

class MangoApp:Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().context(this).build()
    }
}

