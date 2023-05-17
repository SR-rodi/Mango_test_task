package ru.sr.mango_test_task.feature.chat.presentation.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import ru.sr.mango_test_task.core.base.BaseFragment
import ru.sr.mango_test_task.databinding.FragmentChatBinding

import ru.sr.mango_test_task.feature.chat.presentation.chat.adapter.ChatAdapter

class ChatFragment : BaseFragment<FragmentChatBinding>() {

    private val viewModel by viewModels<ChatViewModel>()

    private val adapter by lazy { ChatAdapter(viewModel.currentId) }

    override fun initBinding(inflater: LayoutInflater) = FragmentChatBinding.inflate(inflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.submitList(viewModel.chatList)
        binding.recyclerView.adapter = adapter

    }


}