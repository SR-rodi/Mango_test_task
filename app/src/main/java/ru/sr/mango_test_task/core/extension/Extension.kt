package ru.sr.mango_test_task.core.extension

import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import ru.sr.mango_test_task.app.MangoApp
import ru.sr.mango_test_task.di.AppComponent

fun Context.appComponent(): AppComponent =
    when (this) {
        is MangoApp -> appComponent
        else -> this.applicationContext.appComponent()
    }

fun Spinner.setOnSelectedItem(onSelect: (position: Int) -> Unit) {
    this.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(
            parent: AdapterView<*>?,
            view: View?,
            position: Int,
            id: Long,
        ) {
            onSelect(position)
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {

        }

    }
}