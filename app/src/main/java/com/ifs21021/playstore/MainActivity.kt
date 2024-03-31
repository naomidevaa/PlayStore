package com.ifs21021.playstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)

        val viewPager: ViewPager = findViewById(R.id.view_pager)
        val tabLayout: TabLayout = findViewById(R.id.tabs_layout)

        // Memanggil adapter ViewPager dengan menggunakan supportFragmentManager
        val adapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter

        // Menghubungkan ViewPager dengan TabLayout
        tabLayout.setupWithViewPager(viewPager)
    }

    inner class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> HomeFragment()
                else -> AplikasiFragment()
            }
        }

        override fun getCount(): Int {
            return 2
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return when (position) {
                0 -> "Untuk anda"
                else -> "Paling populer"
            }
        }
    }
}