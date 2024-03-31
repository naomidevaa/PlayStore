package com.ifs21021.playstore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AplikasiFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_aplikasi, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView_aplikasi)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = AppAdapter(getApps())

        return view
    }

    private fun getApps(): List<App> {
        val appNames = resources.getStringArray(R.array.app_names)
        val appIcons = resources.obtainTypedArray(R.array.app_icons)

        val apps = mutableListOf<App>()
        for (i in appNames.indices) {
            val appName = appNames[i]
            val appIconId = appIcons.getResourceId(i, -1)
            val app = App(appName, appIconId)
            apps.add(app)
        }

        appIcons.recycle()

        return apps
    }
}