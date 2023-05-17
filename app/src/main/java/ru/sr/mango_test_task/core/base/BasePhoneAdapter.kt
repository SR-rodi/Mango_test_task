package ru.sr.mango_test_task.core.base

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.viewbinding.ViewBinding

abstract class BasePhoneAdapter<T : Any, VB : ViewBinding>() : BaseAdapter() {

    protected val items = mutableListOf<T>()

    fun setItems(list: List<T>) {
        items.clear()
        items.addAll(list)
    }

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): T = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    abstract fun initBinding(parent: ViewGroup): VB

    abstract fun bind(binding: VB, position: Int)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        return if (parent != null) {
            val binding = initBinding(parent)
            bind(binding, position)
            binding.root
        } else convertView
    }

}