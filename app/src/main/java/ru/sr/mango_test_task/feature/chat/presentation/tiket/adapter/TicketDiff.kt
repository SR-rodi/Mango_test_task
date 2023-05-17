package ru.sr.mango_test_task.feature.chat.presentation.tiket.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.sr.mango_test_task.feature.chat.presentation.tiket.model.Ticket

class TicketDiff : DiffUtil.ItemCallback<Ticket>() {
    override fun areItemsTheSame(oldItem: Ticket, newItem: Ticket) =
        newItem.creation == oldItem.creation

    override fun areContentsTheSame(oldItem: Ticket, newItem: Ticket) =
        newItem == oldItem
}