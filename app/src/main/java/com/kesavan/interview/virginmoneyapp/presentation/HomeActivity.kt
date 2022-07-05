package com.kesavan.interview.virginmoneyapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.kesavan.interview.virginmoneyapp.R
import com.kesavan.interview.virginmoneyapp.databinding.ActivityHomeBinding
import com.kesavan.interview.virginmoneyapp.utils.colorsList

class HomeActivity : AppCompatActivity() {

    private val binding: ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.viewPager.adapter = FragmentAdapter(this)

        TabLayoutMediator(binding.tabLayout, binding.viewPager){ tab, position ->
            when(position){
                0 -> {
                    tab.text = "People"
                    tab.setIcon(R.drawable.ic_people)
                }
                else -> {
                    tab.text = "Room"
                    tab.setIcon(R.drawable.ic_room)
                }
            }

        }.attach()
        val color= colorsList().filter { colorName ->
            colorName.name.lowercase() =="red"
        }.single()
        Log.d("TAG1231321", "onCreate: "+color.name)
    }

    class FragmentAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity){
        override fun getItemCount(): Int {
            return 2
        }

        override fun createFragment(position: Int): Fragment {
            return TabFragment.newInstance(position)
        }

    }
}