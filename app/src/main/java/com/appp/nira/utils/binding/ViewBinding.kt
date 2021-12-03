package com.appp.nira.utils.binding

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.appp.nira.models.LoanPlannerModel
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.request.RequestOptions
import com.github.florent37.glidepalette.BitmapPalette
import com.github.florent37.glidepalette.GlidePalette
import com.google.android.material.slider.Slider
import com.skydoves.whatif.whatIfNotNullOrEmpty

object ViewBinding {


    @JvmStatic
    @BindingAdapter("formatString")
    fun bindAmount(view: AppCompatTextView, amount: Int) {

        view.text = String.format("%,d", amount)
    }

    @JvmStatic
    @BindingAdapter("sliderValue")
    fun bindSlider(view: Slider, loanPlannerModel: LoanPlannerModel) {

        view.apply {
            stepSize = loanPlannerModel.loanMover.toFloat()
            value = loanPlannerModel.defaultLoanAmount.toFloat()
            valueFrom = loanPlannerModel.loanLowerLimit.toFloat()
            valueTo = loanPlannerModel.loanUpperLimit.toFloat()
        }
    }

    @JvmStatic
    @BindingAdapter("sliderIValue")
    fun bindISlider(view: Slider, loanPlannerModel: LoanPlannerModel) {


        view.apply {
            stepSize = loanPlannerModel.tenurMover.toFloat()
            value = loanPlannerModel.tenurDefault.toFloat()
            valueFrom = loanPlannerModel.tenureMin.toFloat()
            valueTo = loanPlannerModel.tenureMax.toFloat()
        }
    }

    @JvmStatic
    @BindingAdapter("formatAmountString")
    fun bindForamteAmount(view: AppCompatTextView, amount: Int) {
        view.text = " Loan Amount ${String.format("%,d", amount)}"
    }

    @JvmStatic
    @BindingAdapter("formatTenureString")
    fun bindForamteTenure(view: AppCompatTextView, amount: Int) {

        view.text = " Tenure $amount months"
    }

    @JvmStatic
    @BindingAdapter("intValue")
    fun bindIntView(view: AppCompatTextView, amount: Int) {

        view.text = amount.toString()

    }

    @JvmStatic
    @BindingAdapter("interestValue")
    fun bindInterest(view: AppCompatTextView, amount: Int) {


        view.text = "Interest @ $amount% per month"
    }

    @JvmStatic
    @BindingAdapter("bindTotalAmount")
    fun bindLoanAmount(view: AppCompatTextView, model: LoanPlannerModel) {


        val amount = (model.amount + model.interest) / model.tenurDefault

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
    fun bindLoadImage(imageView: AppCompatImageView, url: String) {


        Glide.with(imageView.context)
            .load(url)
            .apply(RequestOptions.circleCropTransform().priority(Priority.HIGH))
            .into(imageView)
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
