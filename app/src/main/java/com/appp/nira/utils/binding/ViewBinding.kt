package com.appp.nira.utils.binding

import android.util.Log
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.appp.nira.models.LoanPlannerModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.github.florent37.glidepalette.BitmapPalette
import com.github.florent37.glidepalette.GlidePalette
import com.skydoves.whatif.whatIfNotNullOrEmpty

object ViewBinding {


    @JvmStatic
    @BindingAdapter("formatString")
    fun bindAmount(view: AppCompatTextView, amount: Int) {

        Log.d("keyur", "formatString $amount")
        view.text = String.format("%,d", amount)
    }

    @JvmStatic
    @BindingAdapter("intValue")
    fun bindIntView(view: AppCompatTextView, amount: Int) {
        Log.d("keyur", "intValue $amount")

        view.text = amount.toString()

    }

    @JvmStatic
    @BindingAdapter("interestValue")
    fun bindInterest(view: AppCompatTextView, amount: Int) {

        Log.d("keyur", "interestValue $amount")

        view.setText("Interest @ $amount% per month")
    }

    @JvmStatic
    @BindingAdapter("bindTotalAmount")
    fun bindLoanAmount(view: AppCompatTextView, model: LoanPlannerModel) {

        Log.d("keyur", "bindTotalAmount")

        val amount = model.amount + model.interest

        Log.d("keyur", "bindTotalAmount $amount")

        view.text = String.format("%,d", amount);

    }

    @JvmStatic
    @BindingAdapter("loadCircleImage")
    fun bindLoadCircleImage(view: AppCompatImageView, url: String) {
        Glide.with(view.context)
            .load(url)
            .apply(RequestOptions().circleCrop())
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("loadImage")
    fun bindLoadImage(view: AppCompatImageView, url: String) {
        Glide.with(view)
            .load(url)
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("loadPaletteImage", "loadPaletteTarget")
    fun bindLoadImage(view: AppCompatImageView, url: String, targetView: View) {
        Glide.with(view)
            .load(url)
            .listener(
                GlidePalette.with(url)
                    .use(BitmapPalette.Profile.VIBRANT)
                    .intoBackground(targetView)
                    .crossfade(true)
            )
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("visibilityByResource")
    fun bindVisibilityByResource(view: View, anyList: List<Any>?) {
        anyList.whatIfNotNullOrEmpty {
            //view.visible()
        }
    }


}
