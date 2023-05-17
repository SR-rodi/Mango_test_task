package ru.sr.mango_test_task.feature.chat.presentation.tiket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import ru.sr.mango_test_task.core.base.BaseFragment
import ru.sr.mango_test_task.core.extension.showToast
import ru.sr.mango_test_task.databinding.FragmentTicketsRoomBinding
import ru.sr.mango_test_task.feature.chat.presentation.tiket.adapter.TicketsAdapter

class TicketsRoomFragment : BaseFragment<FragmentTicketsRoomBinding>() {

    private val viewModel by viewModels<TicketsRoomViewModel>()

    private val adapter by lazy { TicketsAdapter(::onClickItem) }

    override fun initBinding(inflater: LayoutInflater) =
        FragmentTicketsRoomBinding.inflate(inflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.submitList(viewModel.listTickets)
        binding.recyclerView.adapter = adapter
    }

    private fun onClickItem(position: Int) {
        showToast("click to position = $position")
        navigation(TicketsRoomFragmentDirections.actionTicketsRoomFragmentToChatFragment())
    }
}