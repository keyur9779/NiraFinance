package com.appp.nira.utils.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.appp.nira.view.adapter.RecyclerViewAdapter

object RecyclerViewBinding {


    @JvmStatic
    @BindingAdapter("adapter")
    fun bindAdapter(view: RecyclerView, baseAdapter: RecyclerViewAdapter) {
        view.adapter = baseAdapter
    }

}
