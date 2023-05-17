package ru.sr.mango_test_task.core.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseChatViewHolder<T>(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(item: T)
}