package ru.sr.mango_test_task.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import ru.sr.mango_test_task.core.extension.appComponent

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    private var _binding: VB? = null
    protected val binding get() = _binding!!

    protected abstract fun initBinding(inflater: LayoutInflater): VB

    inline fun <reified VM : ViewModel> initViewModel(): VM {
        val viewModel by viewModels<VM> { requireContext().appComponent().viewModelFactory }
        return viewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = initBinding(inflater)
        return binding.root
    }

    fun <I : Any?> flowObserver(flow: Flow<I>, block: suspend (it: I) -> Unit) {
        viewLifecycleOwner.lifecycleScope.launch {
            flow.collect {
                block(it)
            }
        }
    }

    protected fun navigation(directions: NavDirections) {
        findNavController().navigate(directions)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}