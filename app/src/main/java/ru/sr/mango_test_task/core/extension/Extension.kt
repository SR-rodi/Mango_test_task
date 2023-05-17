package ru.sr.mango_test_task.core.extension

import android.annotation.SuppressLint
import android.content.Context
import android.icu.text.SimpleDateFormat
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.Spinner
import com.bumptech.glide.Glide
import ru.sr.mango_test_task.app.MangoApp
import ru.sr.mango_test_task.di.AppComponent
import ru.sr.mango_test_task.feature.profile.domain.model.UserProfileDomainModel
import ru.sr.mango_test_task.feature.profile.presentation.UserProfileUIModel
import java.util.Date

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

fun UserProfileDomainModel.toUi() =
    UserProfileUIModel(id, avatar, birthday, city, username, name, phone)

fun ImageView.loadImage(uri: Any?) {
    Glide.with(this)
        .load(uri)
        .into(this)
}


@SuppressLint("SimpleDateFormat")
fun String.simpleDateFormat(from: String, to: String): String {

    val formatter = SimpleDateFormat(from)
    val mDate = formatter.parse(this) as Date// this never ends while debugging
    Log.e("mDate", mDate.toString())
    val newFormat = SimpleDateFormat(to)
    return newFormat.format(mDate)
}