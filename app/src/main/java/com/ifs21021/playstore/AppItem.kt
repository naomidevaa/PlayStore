package com.ifs21021.playstore

import android.content.Context
import android.util.AttributeSet
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.TextView

class AppItem : GridLayout {
    private val imageView: ImageView
    private val textView: TextView

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        // Inflate layout
        inflate(context, R.layout.item_app, this)

        // Initialize views
        imageView = findViewById(R.id.ivAppIcon)
        textView = findViewById(R.id.textViewAppName)
    }

    fun setAppName(appName: String) {
        textView.text = appName
    }

    fun setAppIcon(resId: Int) {
        imageView.setImageResource(resId)
    }
}
