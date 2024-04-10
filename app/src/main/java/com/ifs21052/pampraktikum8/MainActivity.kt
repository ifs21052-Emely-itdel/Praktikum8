package com.ifs21052.pampraktikum8

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.ifs21052.pampraktikum8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
        setupAction()
    }
    private fun setupView() {
        binding.inAppBar.bottomNavView.menu.findItem(R.id.navigation_chat)
        binding.inAppBar.toolbar.overflowIcon =
            ContextCompat.getDrawable(this, R.drawable.ic_more_vert)
        loadFragment(FLAG_FRAGMENT_CHAT)
    }
    private fun setupAction() {
//        binding.inAppBar.toolbar.setNavigationOnClickListener {
//            binding.drawerLayout.openDrawer(GravityCompat.START)
//        }
        binding.inAppBar.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                // Misalnya, jika kode ini berada dalam sebuah kelas yang mewarisi AppCompatActivity,
// Anda dapat menggunakan 'this' sebagai konteks:

                R.id.action_camera -> {
                    Toast.makeText(this, "Memilih menu camera!", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.action_search -> {
                    Toast.makeText(this, "Memilih menu search!", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.action_group -> {
                    Toast.makeText(this, "Memilih menu new group!", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.action_broadcast -> {
                    Toast.makeText(this, "Memilih menu new broadcast!", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.action_linked -> {
                    Toast.makeText(this, "Memilih menu linked devices!", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.action_starred -> {
                    Toast.makeText(this, "Memilih menu starred messages!", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.action_settings -> {
                    Toast.makeText(this, "Memilih menu settings!", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> true
            }
        }


        binding.inAppBar.bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_chat -> {
                    loadFragment(FLAG_FRAGMENT_CHAT)
                    true
                }
                R.id.navigation_updates -> {
                    loadFragment(FLAG_FRAGMENT_UPDATES)
                    true
                }
                R.id.navigation_communities -> {
                    loadFragment(FLAG_FRAGMENT_COMMUNITY)
                    true
                }
                R.id.navigation_calls -> {
                    loadFragment(FLAG_FRAGMENT_CALLS)
                    true
                }
                else -> true
            }
        }
    }

    private fun loadFragment(flag: String, message: String? = null) {
        val fragmentManager = supportFragmentManager
        val fragmentContainerId =
            binding.inAppBar.inContentMain.frameContainer.id
        when (flag) {
            FLAG_FRAGMENT_CHAT -> {
                binding.inAppBar.bottomNavView
                    .menu
                    .findItem(R.id.navigation_chat)
                    .setChecked(true)
                val chatFragment = ChatFragment()
                val bundle = Bundle().apply {
                    this.putString(
                        ChatFragment.EXTRA_MESSAGE,
                        message ?: "Belum ada menu yang dipilih!"
                    )
                }
                chatFragment.arguments = bundle
                fragmentManager
                    .beginTransaction()
                    .replace(
                        fragmentContainerId,
                        chatFragment,
                        ChatFragment::class.java.simpleName
                    )
                    .commit()
            }

            FLAG_FRAGMENT_UPDATES -> {
                val updatesFragment = UpdatesFragment()
                val fragment = fragmentManager
                    .findFragmentByTag(UpdatesFragment::class.java.simpleName)
                if (fragment !is UpdatesFragment) {
                    fragmentManager
                        .beginTransaction()
                        .replace(
                            fragmentContainerId,
                            updatesFragment,
                            UpdatesFragment::class.java.simpleName
                        )
                        .commit()
                }
            }

            FLAG_FRAGMENT_COMMUNITY -> {
                binding.inAppBar.bottomNavView
                    .menu
                    .findItem(R.id.navigation_communities)
                    .setChecked(true)
                val communityFragment = CommunityFragment()
                val bundle = Bundle().apply {
                    this.putString(
                        CommunityFragment.EXTRA_MESSAGE,
                        message ?: "Ini adalah menu community!"
                    )
                }
                communityFragment.arguments = bundle
                fragmentManager
                    .beginTransaction()
                    .replace(
                        fragmentContainerId,
                        communityFragment,
                        CommunityFragment::class.java.simpleName
                    )
                    .commit()
            }

            FLAG_FRAGMENT_CALLS -> {
                binding.inAppBar.bottomNavView
                    .menu
                    .findItem(R.id.navigation_calls)
                    .setChecked(true)
                val callsFragment = CallsFragment()
                val bundle = Bundle().apply {
                    this.putString(
                        ChatFragment.EXTRA_MESSAGE,
                        message ?: "Ini adalah menu calls!"
                    )
                }
                callsFragment.arguments = bundle
                fragmentManager
                    .beginTransaction()
                    .replace(
                        fragmentContainerId,
                        callsFragment,
                        CallsFragment::class.java.simpleName
                    )
                    .commit()
            }
        }
    }
    companion object {
        const val FLAG_FRAGMENT_CHAT = "fragment_chat"
        const val FLAG_FRAGMENT_UPDATES = "fragment_updates"
        const val FLAG_FRAGMENT_COMMUNITY = "fragment_community"
        const val FLAG_FRAGMENT_CALLS = "fragment_calls"
    }
}