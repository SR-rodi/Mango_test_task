package ru.sr.mango_test_task.feature.profile

import android.view.LayoutInflater
import ru.sr.mango_test_task.core.base.BaseFragment
import ru.sr.mango_test_task.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    override fun initBinding(inflater: LayoutInflater) = FragmentProfileBinding.inflate(inflater)


}