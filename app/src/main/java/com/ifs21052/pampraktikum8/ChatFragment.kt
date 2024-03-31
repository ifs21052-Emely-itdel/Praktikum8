package com.ifs21052.pampraktikum8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifs21052.pampraktikum8.databinding.FragmentChatBinding

class ChatFragment : Fragment() {
    private lateinit var binding: FragmentChatBinding
    private val dataListChats = ArrayList<ListChat>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val chatAdapter = ChatAdapter.ChatAdapter(dataListChats)
        binding.rvChat.layoutManager = LinearLayoutManager(requireContext())
        binding.rvChat.adapter = chatAdapter

        // Populate dataListChats with data
        dataListChats.addAll(getListChats())

        // Notify the adapter that data has been changed
        chatAdapter.notifyDataSetChanged()
    }

    private fun getListChats(): ArrayList<ListChat> {
        val dataUsername = resources.getStringArray(R.array.usernames)
        val dataPropic = resources.obtainTypedArray(R.array.propics)
        val dataMessage = resources.getStringArray(R.array.messages)
        val dataTime = resources.getStringArray(R.array.times)

        val listChat = ArrayList<ListChat>()
        for (i in dataUsername.indices) {
            val chat = ListChat(
                dataUsername[i],
                dataPropic.getResourceId(i, -1),
                dataMessage[i],
                dataTime[i]
            )
            listChat.add(chat)
        }
        // Release the TypedArray
        dataPropic.recycle()
        return listChat
    }

    companion object {
        const val EXTRA_MESSAGE = "extra_message"
    }
}
