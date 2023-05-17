package ru.sr.mango_test_task.feature.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import ru.sr.mango_test_task.core.base.BaseFragment
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


        binding.userAvatar.setOnClickListener { getItem.launch("image/*") }

        binding.saveButton.setOnClickListener {
            viewModel.userUpdate()
        }

        viewModel.getUser()

    }
}

fun ImageView.loadImage(uri: Any?) {
    Glide.with(this)
        .load(uri)
        .into(this)
}