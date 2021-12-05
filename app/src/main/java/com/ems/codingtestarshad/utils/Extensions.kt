package com.ems.codingtestarshad.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.ems.codingtestarshad.R

fun ImageView.fetch(url: String){
    Glide
        .with(context)
        .load(url)
        .centerCrop()
        .placeholder(R.drawable.pro_ico)
        .into(this)
}
