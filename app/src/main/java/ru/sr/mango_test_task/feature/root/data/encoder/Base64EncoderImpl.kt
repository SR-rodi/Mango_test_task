package ru.sr.mango_test_task.feature.root.data.encoder

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Base64
import ru.sr.mango_test_task.feature.root.domain.encoder.Base64Encoder
import java.io.ByteArrayOutputStream
import java.io.InputStream

class Base64EncoderImpl(private val applicationContext: Context) : Base64Encoder {
    override fun encodeUriToString(uri: Uri): String {

        val inputStream: InputStream? = applicationContext.contentResolver.openInputStream(uri)
        val bitmap = BitmapFactory.decodeStream(inputStream)

        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.WEBP, 0, stream)
        val byteArray: ByteArray = stream.toByteArray()

        return Base64.encodeToString(byteArray, Base64.DEFAULT)

    }

}