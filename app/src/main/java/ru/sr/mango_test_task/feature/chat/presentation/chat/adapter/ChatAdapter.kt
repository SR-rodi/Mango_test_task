package ru.sr.mango_test_task.feature.chat.presentation.chat.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.sr.mango_test_task.R
import ru.sr.mango_test_task.core.base.BaseViewHolder
import ru.sr.mango_test_task.feature.chat.presentation.chat.model.DisplayChatItem
import ru.sr.mango_test_task.feature.chat.presentation.chat.adapter.diff.ChatDiff
import ru.sr.mango_test_task.feature.chat.presentation.chat.adapter.holder.ChatReceiverViewHolder
import ru.sr.mango_test_task.feature.chat.presentation.chat.adapter.holder.ChatSentViewHolder

class ChatAdapter(private val userId: String) :
    ListAdapter<DisplayChatItem, BaseViewHolder<DisplayChatItem>>(ChatDiff()) {

    private val receivedViewType = R.layout.item_chat_received
    private val sentViewType = R.layout.item_chat_sent

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).sender.userId == userId) sentViewType else receivedViewType
    }

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): BaseViewHolder<DisplayChatItem> =when (viewType) {
            receivedViewType -> ChatReceiverViewHolder.create(parent) as BaseViewHolder<DisplayChatItem>
            else -> ChatSentViewHolder.create(parent) as BaseViewHolder<DisplayChatItem>
        }

    override fun onBindViewHolder(holder: BaseViewHolder<DisplayChatItem>, position: Int) {
        holder.bind(getItem(position))
    }
}

