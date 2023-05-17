package ru.sr.mango_test_task.feature.profile.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import ru.sr.mango_test_task.R
import ru.sr.mango_test_task.core.base.BaseFragment
import ru.sr.mango_test_task.core.extension.loadImage
import ru.sr.mango_test_task.core.extension.setFormatMask
import ru.sr.mango_test_task.core.extension.setMask
import ru.sr.mango_test_task.core.extension.showToast
import ru.sr.mango_test_task.databinding.FragmentProfileBinding
import ru.sr.mango_test_task.feature.profile.presentation.model.ProfileAction
import ru.sr.mango_test_task.feature.profile.presentation.model.ProfileState

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    private val viewModel by lazy { initViewModel<ProfileViewModel>() }

    private val getItem = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        if (uri != null) {
            binding.userAvatar.loadImage(uri)
            viewModel.saveUri(uri)
        }
    }

    override fun initBinding(inflater: LayoutInflater) = FragmentProfileBinding.inflate(inflater)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        baseSettingsFragment()
        flowObserver(viewModel.viewStates()) { state -> stateObserver(state) }
        flowObserver(viewModel.viewAction()) { action -> actionObserver(action) }
        binding.userAvatar.setOnClickListener { getItem.launch(INPUT) }
        binding.saveButton.setOnClickListener { updateButtonClick() }
        binding.chatButton.setOnClickListener {
            navigation(ProfileFragmentDirections.actionProfileFragmentToTicketsRoomFragment())
        }
    }

    private fun updateButtonClick() =
        viewModel.userUpdate(binding.birthDay.text.toString(), binding.city.text.toString())

    private fun baseSettingsFragment() {
        binding.birthDay.setFormatMask(MASK)
        binding.birthDay.setMask()
    }

    private fun stateObserver(state: ProfileState) = binding.apply {
        progressBar.isVisible = state.isLoading
        errorNetwork.error.isVisible = state.isError
        birthDay.setText(state.user?.birthday)
        phoneNumber.setText(state.user?.phone)
        userName.setText(state.user?.username)
        city.setText(state.user?.city)
        userAvatar.loadImage(state.user?.avatar)
    }

    private fun actionObserver(action: ProfileAction?) = when (action) {
        ProfileAction.ShowSuccessToast ->
            showToast(getString(R.string.profile_update_success_message))

        null -> {}
    }

    private companion object {
        const val MASK = "XX.XX.XXXX"
        const val INPUT = "image/*"
    }
}