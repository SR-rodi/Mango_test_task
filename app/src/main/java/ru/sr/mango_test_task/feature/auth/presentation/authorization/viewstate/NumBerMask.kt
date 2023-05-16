package ru.sr.mango_test_task.feature.auth.presentation.authorization.viewstate

import androidx.core.widget.doAfterTextChanged
import com.google.android.material.textfield.TextInputEditText

fun TextInputEditText.setFormatMask(new: String) {
    NumberFormat.format = new
}


object NumberFormat{
    var format  = "(XXX)-XX-XX"
}

fun TextInputEditText.toStringWithoutMask(): String {
    val stingBuilder = StringBuilder()
    stingBuilder.setLength(0)
    this.text.toString().forEach { char->
        if (char in '0'..'9')
            stingBuilder.append(char)
    }
    return stingBuilder.toString()
}

fun TextInputEditText.setMask() {
    val numPlace = 'X'
    val stingBuilder = StringBuilder()
    var ignore = false
    doAfterTextChanged { editable ->
        if (!ignore) {
            stingBuilder.setLength(0)
            editable?.forEach { char ->
                if (char in '0'..'9')
                    stingBuilder.append(char)
            }
            val numbers = stingBuilder.toString()
            stingBuilder.setLength(0)

            var i = 0
            var textIndex = 0
            if (editable != null)
                while (i < NumberFormat.format.length && textIndex < numbers.length) {
                    if (NumberFormat.format[i] == numPlace) {

                        stingBuilder.append(numbers[textIndex])
                        textIndex++
                    } else {
                        stingBuilder.append(NumberFormat.format[i])
                    }
                    i++
                }

            ignore = true
            editable?.replace(0, editable.length, stingBuilder.toString())
            ignore = false
        }
    }
}
