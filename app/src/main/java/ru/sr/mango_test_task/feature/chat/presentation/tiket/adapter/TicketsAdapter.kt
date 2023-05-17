package ru.sr.mango_test_task.feature.chat.presentation.tiket.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.sr.mango_test_task.feature.chat.presentation.tiket.model.Ticket

class TicketsAdapter(
    private val onClick: (Int) -> Unit,
) : ListAdapter<Ticket, TicketViewHolder>(TicketDiff()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TicketViewHolder.create(parent, onClick)

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

