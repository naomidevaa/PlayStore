package com.ifs21021.playstore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.ifs21021.playstore.databinding.FragmentCategoriesBinding

class CategoriesFragment : Fragment() {
    private lateinit var binding: FragmentCategoriesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager = binding.vpFragmentCategories as ViewPager2 // Mengubah ke ViewPager2
        val pagerAdapter = CategoriesPagerAdapter(requireActivity())
        viewPager.adapter = pagerAdapter
        val tabs = binding.tabFragmentCategories
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = TAB_TITLES[position]
        }.attach()
    }

    companion object {
        private val TAB_TITLES = arrayOf(
            "Untuk anda",
            "Kategori populer"
        )
    }
}