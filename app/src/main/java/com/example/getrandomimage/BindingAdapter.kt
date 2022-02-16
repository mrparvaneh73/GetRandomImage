package com.example.getrandomimage

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class BindingAdapter1 {
    companion object {
        @JvmStatic
        @BindingAdapter("profileImage")
        fun loadImage(view: ImageView, url: String) {
            Glide.with(view.context)
                .load(url)
                .placeholder(R.drawable.loading_animation)
                .into(view)
        }
    }
}