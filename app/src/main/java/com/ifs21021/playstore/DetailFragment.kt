package com.ifs21021.playstore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ifs21021.playstore.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Dummy data for the list of apps (you can replace this with your actual data)
        val apps = listOf("App 1", "App 2", "App 3", "App 4", "App 5", "App 6", "App 7", "App 8")

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewApps)
        val layoutManager = GridLayoutManager(requireContext(), 4) // 4 aplikasi secara horizontal
        recyclerView.layoutManager = layoutManager
    }

    companion object {
        const val EXTRA_INFO = "extra_info"
    }
}