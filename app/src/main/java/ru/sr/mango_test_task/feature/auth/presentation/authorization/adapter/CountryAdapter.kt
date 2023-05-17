package ru.sr.mango_test_task.feature.auth.presentation.authorization.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import ru.sr.mango_test_task.core.base.BasePhoneAdapter
import ru.sr.mango_test_task.databinding.DropdownCountryItemBinding

class CountryAdapter : BasePhoneAdapter<Int, DropdownCountryItemBinding>() {

    override fun initBinding(parent: ViewGroup) =
        DropdownCountryItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

    override fun bind(binding: DropdownCountryItemBinding, position: Int) {
        binding.image.setImageResource(items[position])
    }
}