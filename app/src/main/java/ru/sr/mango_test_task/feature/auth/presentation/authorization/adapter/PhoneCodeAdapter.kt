package ru.sr.mango_test_task.feature.auth.presentation.authorization.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import ru.sr.mango_test_task.core.base.BasePhoneAdapter
import ru.sr.mango_test_task.databinding.DropdownCodeItemBinding
import ru.sr.mango_test_task.feature.auth.data.PhoneFormat

class PhoneCodeAdapter : BasePhoneAdapter<PhoneFormat, DropdownCodeItemBinding>() {

    override fun initBinding(parent: ViewGroup) =
        DropdownCodeItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)


    override fun bind(binding: DropdownCodeItemBinding, position: Int) {
        binding.phoneCode.text = items[position].code
    }
}