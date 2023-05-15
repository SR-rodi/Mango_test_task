package ru.sr.mango_test_task.feature.auth.presentation.authorization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.findNavController
import ru.sr.mango_test_task.databinding.FragmentAuthorizationBinding
import ru.sr.mango_test_task.presentations.auth.authorization.AuthorizationFragmentDirections
import ru.sr.mango_test_task.core.base.BaseFragment
import ru.sr.mango_test_task.core.base.LoadingState

class AuthorizationFragment : BaseFragment<FragmentAuthorizationBinding>() {

    private val viewModel by lazy { initViewModel<AuthorizationViewModel>() }

    override fun initBinding(inflater: LayoutInflater) =
        FragmentAuthorizationBinding.inflate(inflater)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onAuthClickButton()
        binding.phone.setText("+79219999999")
        stateObserver(viewModel.loadingState()) { state -> observer(state) }
    }

    private fun observer(state: LoadingState) {
        if (state == LoadingState.Success) {
            findNavController().navigate(
                AuthorizationFragmentDirections.actionAuthorizationFragmentToConfirmationCodeFragment(
                    binding.phone.text.toString()
                )
            )
            viewModel.onResetLoadingState()
        }

    }

    private fun onAuthClickButton() {
        binding.authButton.setOnClickListener {
            viewModel.sendPhone(binding.phone.text.toString())
        }
    }

}