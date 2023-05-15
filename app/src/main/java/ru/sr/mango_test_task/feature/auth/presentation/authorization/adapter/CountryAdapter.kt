package ru.sr.mango_test_task.feature.auth.presentation.authorization.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import ru.sr.mango_test_task.databinding.DropdownCountryItemBinding

class CountryAdapter(
    private val items: List<Int>,
) : BaseAdapter() {
    override fun getCount() = items.size

    override fun getItem(position: Int): Int {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        return if (parent != null) {
            val binding = DropdownCountryItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
            binding.image.setImageResource(items[position])
            binding.root
        } else convertView
    }
}