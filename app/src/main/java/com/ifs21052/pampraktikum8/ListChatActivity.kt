package com.ifs21052.pampraktikum8

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifs21052.pampraktikum8.databinding.ActivityListChatBinding

class ListChatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListChatBinding
    private val dataListChats = ArrayList<ListChat>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvChat.setHasFixedSize(false)
        dataListChats.addAll(getListChats())
        showRecyclerList()
    }


    @SuppressLint("Recycle")
    private fun getListChats(): ArrayList<ListChat> {
        val dataUsername =
            resources.getStringArray(R.array.usernames)
        val dataPropic =
            resources.obtainTypedArray(R.array.propics)
        val dataMessage =
            resources.getStringArray(R.array.messages)
        val dataTime =
            resources.getStringArray(R.array.times)

        val listChat = ArrayList<ListChat>()
        for (i in dataUsername.indices) {
            val chat = ListChat(
                dataUsername[i],
                dataPropic.getResourceId(i, -1), dataMessage[i], dataTime[i],
            )
            listChat.add(chat)
        }
        return listChat
    }

    private fun showRecyclerList() {
        if (resources.configuration.orientation ==
            Configuration.ORIENTATION_LANDSCAPE
        ) {
            binding.rvChat.layoutManager =
                GridLayoutManager(this, 2)
        } else {
            binding.rvChat.layoutManager =
                LinearLayoutManager(this)
        }
    }
}

//        val chatAdapter = ChatAdapter.ChatAdapter(dataListChats)
//        binding.rvChat.adapter = chatAdapter
//        ChatAdapter.setOnItemClickCallback(object :
//            ChatAdapter.OnItemClickCallback {
//            override fun onItemClicked(data: ListChat) {
//                showSelectedChat(data)
//            }
//        })
//    }

//    private fun showSelectedChat(chat: ListChat) {
//        val intentWithData = Intent(this@MainActivity,
//            DetailActivity052::class.java)
//        intentWithData.putExtra(DetailActivity052.EXTRA_DINO, famDino)
//        startActivity(intentWithData)
//    }


//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.menu_about -> {
//                val intent = Intent(this, ProfileActivity::class.java)
//                startActivity(intent)
//                true
//            }
//            R.id.menu_baru -> {
//                val intent = Intent(this, GambarDino::class.java)
//                startActivity(intent)
//                true
//            }
//            R.id.menu_toast -> {
//                val intent = Intent(this, MenuDinoActivity::class.java)
//                startActivity(intent)
//                true
//            }
//        }
//        return true
//    }
//
//    private fun showToast() {
//        Toast.makeText(
//            this, "Maaf, menu belum sempat dibuat",
//            Toast.LENGTH_SHORT
//        ).show()
//    }
//}