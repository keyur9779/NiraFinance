package com.appp.nira.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.appp.nira.R
import com.appp.nira.databinding.RowImageBinding
import com.appp.nira.models.ImageModel
import com.mindinventory.overlaprecylcerview.adapters.OverlapRecyclerViewAdapter
import com.skydoves.bindables.binding

class RecyclerViewAdapter(
    overlapLimit: Int,
    overlapWidthInPercentage: Int
) : OverlapRecyclerViewAdapter<ImageModel, RecyclerViewAdapter.CustomViewHolder>(
    overlapLimit,
    overlapWidthInPercentage
) {

    override fun createItemViewHolder(parent: ViewGroup): CustomViewHolder {

        val binding = parent.binding<RowImageBinding>(R.layout.row_image)
        return CustomViewHolder(binding)

    }

    override fun bindItemViewHolder(viewHolder: CustomViewHolder, position: Int) {
        val currentImageModel = visibleItems[position]


        with(viewHolder.rowImageBinding) {
            data = currentImageModel
        }
    }

    override fun getItemCount() = visibleItems.size

    inner class CustomViewHolder(val rowImageBinding: RowImageBinding) :
        RecyclerView.ViewHolder(rowImageBinding.root) {

    }
}

