package com.example.bonusassignment.adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.bonusassignment.fragments.fragment_input
import com.example.bonusassignment.fragments.fragment_profile

class ViewPagerFragmentAdapter(activity:AppCompatActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> fragment_profile()
            1 -> fragment_input()
            else -> fragment_profile()
        }
    }


}