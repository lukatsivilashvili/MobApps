package com.example.adapters.adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.adapters.fragments.fragmentOne
import com.example.adapters.fragments.fragmentThree
import com.example.adapters.fragments.fragmentTwo

class ViewPagerFragmentAdapter(activity:AppCompatActivity):FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> fragmentOne()
            1 -> fragmentTwo()
            2 -> fragmentThree()
            else -> fragmentOne()
        }
    }
}