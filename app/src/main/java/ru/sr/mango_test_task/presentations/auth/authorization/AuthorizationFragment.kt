package ru.sr.mango_test_task.presentations.auth.authorization

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.sr.mango_test_task.R
import ru.sr.mango_test_task.databinding.FragmentAuthorizationBinding
import ru.sr.mango_test_task.root.core.base.BaseFragment

class AuthorizationFragment : BaseFragment<FragmentAuthorizationBinding>() {

    override fun initBinding(inflater: LayoutInflater) =
        FragmentAuthorizationBinding.inflate(inflater)

}