package ru.sr.mango_test_task.feature.chat.presentation.tiket.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import ru.sr.mango_test_task.core.base.BaseViewHolder
import ru.sr.mango_test_task.databinding.ItemTicketBinding
import ru.sr.mango_test_task.feature.chat.presentation.tiket.model.Ticket

class TicketViewHolder(private val binding: ItemTicketBinding, onClick: (Int) -> Unit) :
    BaseViewHolder<Ticket>(binding) {
    init {
        binding.root.setOnClickListener {
            onClick(adapterPosition)
        }
    }

    override fun bind(item: Ticket) {
        binding.date.text = item.creation
        binding.title.text = item.title
        binding.creator.text = item.creator
        binding.time.text = item.time

    }

    companion object {
        fun create(parent: ViewGroup, onClick: (Int) -> Unit) = TicketViewHolder(
            ItemTicketBinding.inflate(LayoutInflater.from(parent.context), parent, false), onClick
        )
    }
}