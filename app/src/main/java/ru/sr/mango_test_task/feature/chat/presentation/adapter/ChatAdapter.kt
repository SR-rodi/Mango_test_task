package ru.sr.mango_test_task.feature.chat.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.sr.mango_test_task.R
import ru.sr.mango_test_task.core.base.BaseChatViewHolder
import ru.sr.mango_test_task.feature.chat.presentation.model.DisplayChatItem
import ru.sr.mango_test_task.feature.chat.presentation.adapter.diff.ChatDiff
import ru.sr.mango_test_task.feature.chat.presentation.adapter.holder.ChatReceiverViewHolder
import ru.sr.mango_test_task.feature.chat.presentation.adapter.holder.ChatSentViewHolder

class ChatAdapter(private val userId: String) :
    ListAdapter<DisplayChatItem, BaseChatViewHolder<DisplayChatItem>>(ChatDiff()) {

    private val receivedViewType = R.layout.item_chat_received
    private val sentViewType = R.layout.item_chat_sent

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).sender.userId == userId) sentViewType else receivedViewType
    }

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): BaseChatViewHolder<DisplayChatItem> =when (viewType) {
            receivedViewType -> ChatReceiverViewHolder.create(parent) as BaseChatViewHolder<DisplayChatItem>
            else -> ChatSentViewHolder.create(parent) as BaseChatViewHolder<DisplayChatItem>
        }

    override fun onBindViewHolder(holder: BaseChatViewHolder<DisplayChatItem>, position: Int) {
        holder.bind(getItem(position))
    }
}

