package com.ifs21021.playstore

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.item_app, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 4) // 4 kolom dalam grid
        recyclerView.adapter = AppAdapter(getApps())

        return view
    }

    private fun getApps(): List<App> {
        // Ambil data aplikasi dari string.xml dan item_app
        val appNames = resources.getStringArray(R.array.app_names)
        val appIcons = resources.obtainTypedArray(R.array.app_icons)

        val apps = mutableListOf<App>()
        for (i in appNames.indices) {
            apps.add(App(appNames[i], appIcons.getResourceId(i, -1)))
        }

        appIcons.recycle() // Recycle the typed array

        return apps
    }
}