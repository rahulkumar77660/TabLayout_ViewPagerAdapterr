package com.example.tablayout_viewpageradapterr

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val tablayout=findViewById<TabLayout>(R.id.tablayout)
        val viewpager=findViewById<ViewPager>(R.id.viewpager)
        val pagerAdapter=ViewPagerAdapter(supportFragmentManager)

        pagerAdapter.fargments.add(postsfragment())
        pagerAdapter.fargments.add(commentfragment())
        pagerAdapter.fargments.add(albumsfragment())
        pagerAdapter.fargments.add(photos())
        pagerAdapter.fargments.add(todosfragment())
        pagerAdapter.fargments.add(Usersfragment())
        viewpager.adapter=pagerAdapter
        tablayout.setupWithViewPager(viewpager)

        tablayout.getTabAt(0)?.setText("Posts")
        tablayout.getTabAt(1)?.setText("com")
        tablayout.getTabAt(2)?.setText("album")
        tablayout.getTabAt(3)?.setText("Photo")
        tablayout.getTabAt(4)?.setText("todos")
        tablayout.getTabAt(5)?.setText("users")




    }

}