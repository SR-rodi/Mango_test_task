package ru.sr.mango_test_task.feature.chat.presentation.model

data class MessageItem(
    var created: String,
    val text: String,
    override val sender: Sender,
    override val id: Int,
) : DisplayChatItem