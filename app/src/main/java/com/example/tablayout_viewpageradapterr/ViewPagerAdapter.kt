package com.example.tablayout_viewpageradapterr

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fargmentManager:FragmentManager):FragmentPagerAdapter(fargmentManager) {

    val fargments:MutableList<Fragment> = ArrayList()
    override fun getCount(): Int {
    return fargments.size
    }

    override fun getItem(position: Int): Fragment {
        return fargments[position]

    }

    override fun getPageTitle(position: Int): CharSequence? {

        when(position){
            0-> return null
            1-> return "Posts"
            2->return "Comments"
            3->return "albums"//
            4->return "Photos"
            5->return "todos"
            6->return "users"
        }
        return super.getPageTitle(position)
    }


}