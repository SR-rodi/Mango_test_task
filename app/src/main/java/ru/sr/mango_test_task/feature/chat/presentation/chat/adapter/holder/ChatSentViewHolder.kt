package ru.sr.mango_test_task.feature.chat.presentation.chat.adapter.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import ru.sr.mango_test_task.core.extension.loadImage
import ru.sr.mango_test_task.databinding.ItemChatSentBinding
import ru.sr.mango_test_task.core.base.BaseViewHolder
import ru.sr.mango_test_task.feature.chat.presentation.chat.model.MessageItem

class ChatSentViewHolder(private val binding: ItemChatSentBinding) :
    BaseViewHolder<MessageItem>(binding) {
    override fun bind(item: MessageItem) {
        binding.apply {
            avatar.loadImage(item.sender.avatar)
            message.text = item.text
            name.text = item.sender.firstName
            data.text = item.created
        }
    }

    companion object {
        fun create(parent: ViewGroup) = ChatSentViewHolder(
            ItemChatSentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    }
}