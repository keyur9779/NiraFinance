package com.appp.nira.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.appp.nira.R
import com.appp.nira.models.ImageModel
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.request.RequestOptions
import com.mindinventory.overlaprecylcerview.adapters.OverlapRecyclerViewAdapter

class RecyclerViewAdapter(
    overlapLimit: Int,
    overlapWidthInPercentage: Int
) : OverlapRecyclerViewAdapter<ImageModel, RecyclerViewAdapter.CustomViewHolder>(
    overlapLimit,
    overlapWidthInPercentage
) {

    override fun createItemViewHolder(parent: ViewGroup): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_image, parent, false)
        return CustomViewHolder(view)
    }

    override fun bindItemViewHolder(viewHolder: CustomViewHolder, position: Int) {
        val currentImageModel = visibleItems[position]
        //----bind data to view
        viewHolder.bind(currentImageModel)
    }

    override fun getItemCount() = visibleItems.size

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<AppCompatImageView>(R.id.imageView)

        fun bind(image: ImageModel) {
            Glide.with(imageView.context)
                .load(image.imageUrl)
                .apply(RequestOptions.circleCropTransform().priority(Priority.HIGH))
                .into(imageView)

        }
    }
}

