package ru.sr.mango_test_task.feature.chat.presentation.adapter.diff

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import ru.sr.mango_test_task.feature.chat.presentation.model.DisplayChatItem

class ChatDiff : DiffUtil.ItemCallback<DisplayChatItem>() {
    override fun areItemsTheSame(oldItem: DisplayChatItem, newItem: DisplayChatItem) =
        newItem.id == oldItem.id

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: DisplayChatItem, newItem: DisplayChatItem) =
        newItem == oldItem
}