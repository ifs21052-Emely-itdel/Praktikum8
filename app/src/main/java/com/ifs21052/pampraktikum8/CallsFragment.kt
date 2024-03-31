package com.ifs21052.pampraktikum8


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ifs21052.pampraktikum8.databinding.FragmentCallsBinding

class CallsFragment : Fragment() {
    private lateinit var binding: FragmentCallsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCallsBinding
            .inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val message = it.getString(EXTRA_MESSAGE)
            binding.tvFragmentCallsMessage.text = message
        }
    }
    companion object {
        const val EXTRA_MESSAGE = "extra_message"
    }
}