package ru.sr.mango_test_task.feature.chat.presentation

import androidx.lifecycle.ViewModel
import ru.sr.mango_test_task.R
import ru.sr.mango_test_task.feature.chat.presentation.model.MessageItem
import ru.sr.mango_test_task.feature.chat.presentation.model.Sender

class ChatViewModel : ViewModel() {
     val currentId = "325"

    val chatList = listOf(
        MessageItem("17.05.2023","Привет", Sender(R.drawable.ic_wifi_off,"Makar","324","Valera"),12),
        MessageItem("17.05.2023","Привет", Sender(R.drawable.ic_wifi_off,"Makar","324","Valera"),12),
        MessageItem("17.05.2023","Привет", Sender(R.drawable.ic_launcher_foreground,"Makar","325","Valera"),12),
        MessageItem("17.05.2023","Привет", Sender(R.drawable.ic_wifi_off,"Makar","324","Valera"),12),
        MessageItem("17.05.2023","Привет", Sender(R.drawable.ic_wifi_off,"Makar","324","Valera"),12),
        MessageItem("17.05.2023","Привет", Sender(R.drawable.ic_launcher_foreground,"Makar","325","Valera"),12),
        MessageItem("17.05.2023","Привет", Sender(R.drawable.ic_launcher_foreground,"Makar","325","Valera"),12),
    )

}