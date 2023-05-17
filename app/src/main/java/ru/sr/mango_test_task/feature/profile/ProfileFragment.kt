package ru.sr.mango_test_task.feature.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import ru.sr.mango_test_task.core.base.BaseFragment
import ru.sr.mango_test_task.core.extension.loadImage
import ru.sr.mango_test_task.core.extension.setFormatMask
import ru.sr.mango_test_task.core.extension.setMask
import ru.sr.mango_test_task.databinding.FragmentProfileBinding

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

        flowObserver(viewModel.viewStates()) { state: ProfileState ->

            binding.progressBar.isVisible = state.isLoading
            binding.errorNetwork.error.isVisible = state.isError

            binding.birthDay.setText(state.user?.birthday)
            binding.phoneNumber.setText(state.user?.phone)
            binding.userName.setText(state.user?.username)
            binding.city.setText(state.user?.city)
            binding.userAvatar.loadImage(state.user?.avatar)
        }

        flowObserver(viewModel.viewAction()) { action ->
            when (action) {
                ProfileAction.ShowSuccessToast ->
                    Toast.makeText(requireContext(), "Загрузка прошла успешно", Toast.LENGTH_SHORT)
                        .show()

                null -> {}
            }
        }

        binding.birthDay.setFormatMask("XX.XX.XXXX")
        binding.birthDay.setMask()
        binding.userAvatar.setOnClickListener { getItem.launch("image/*") }

        binding.saveButton.setOnClickListener {
            viewModel.userUpdate(binding.birthDay.text.toString(), binding.city.text.toString())
        }
    }
}

