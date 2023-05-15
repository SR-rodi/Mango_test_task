package ru.sr.mango_test_task.presentations.auth.confirmation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import ru.sr.mango_test_task.R
import ru.sr.mango_test_task.databinding.FragmentConfirmationCodeBinding
import ru.sr.mango_test_task.root.core.base.BaseFragment

class ConfirmationCodeFragment : BaseFragment<FragmentConfirmationCodeBinding>() {

    private val viewModel by lazy { initViewModel<ConfirmationCodeViewModel>() }
    private val args by navArgs<ConfirmationCodeFragmentArgs>()

    override fun initBinding(inflater: LayoutInflater) =
        FragmentConfirmationCodeBinding.inflate(inflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.authButton.setOnClickListener {
            viewModel.checkCode(args.phone, "133337")
        }
    }
}