package ru.sr.mango_test_task.feature.chat.presentation.chat.adapter.diff

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import ru.sr.mango_test_task.feature.chat.presentation.chat.model.DisplayChatItem

class ChatDiff : DiffUtil.ItemCallback<DisplayChatItem>() {
    override fun areItemsTheSame(oldItem: DisplayChatItem, newItem: DisplayChatItem) =
        newItem.id == oldItem.id

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: DisplayChatItem, newItem: DisplayChatItem) =
        newItem == oldItem
}