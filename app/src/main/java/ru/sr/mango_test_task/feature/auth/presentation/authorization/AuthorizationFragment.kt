package ru.sr.mango_test_task.feature.auth.presentation.authorization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import ru.sr.mango_test_task.R
import ru.sr.mango_test_task.core.base.BaseFragment
import ru.sr.mango_test_task.core.base.LoadingState
import ru.sr.mango_test_task.core.extension.setOnSelectedItem
import ru.sr.mango_test_task.databinding.FragmentAuthorizationBinding
import ru.sr.mango_test_task.feature.auth.presentation.authorization.adapter.CountryAdapter

class AuthorizationFragment : BaseFragment<FragmentAuthorizationBinding>() {

    private val viewModel by lazy { initViewModel<AuthorizationViewModel>() }

    private val adapter by lazy {
        ArrayAdapter(
            requireContext(),
            R.layout.dropdown_code_item,
            viewModel.getCountry().values.toTypedArray()
        )
    }
    private val adapterCountry by lazy {
        CountryAdapter(viewModel.getCountry().keys.toList())
    }

    override fun initBinding(inflater: LayoutInflater) =
        FragmentAuthorizationBinding.inflate(inflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        settingSpinners()
        onAuthClickButton()
        stateObserver(viewModel.loadingState()) { state -> observer(state) }
        binding.phone.setText("+79219999999")
    }

    private fun settingSpinners(){
        binding.code.adapter = adapter
        binding.code.setOnSelectedItem { position ->
            binding.country.setSelection(position)
        }

        binding.country.adapter = adapterCountry
        binding.country.setOnSelectedItem { position ->
            binding.code.setSelection(position)
        }
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

    private fun onAuthClickButton() =binding.authButton.setOnClickListener {
            viewModel.sendPhone(binding.phone.text.toString())
        }
}