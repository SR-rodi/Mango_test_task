package ru.sr.mango_test_task.feature.root.domain.encoder

import android.net.Uri

interface Base64Encoder {

    fun encodeUriToString(avatar: Uri): String
}

