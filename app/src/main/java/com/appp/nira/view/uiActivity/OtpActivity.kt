package com.appp.nira.view.uiActivity

import android.annotation.SuppressLint
import android.os.Bundle
import android.transition.Explode
import android.transition.Slide
import android.view.Window
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.appp.nira.R
import com.appp.nira.databinding.OtpLayoutBinding
import com.appp.nira.utils.Constant.numberOfItemToBeOverlapped
import com.appp.nira.utils.Constant.overlapWidthInPercentage
import com.appp.nira.view.adapter.RecyclerViewAdapter
import com.appp.nira.viewDataModels.OtpViewModel
import com.skydoves.bindables.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OtpActivity :
    BindingActivity<OtpLayoutBinding>(R.layout.otp_layout)/*AppCompatActivity()*/ {

    private val otpViewModel: OtpViewModel by viewModels()

    private val userAdapter by lazy {
        RecyclerViewAdapter(numberOfItemToBeOverlapped, overlapWidthInPercentage)
    }

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        with(window) {
            requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)

            // set an exit transition
            exitTransition = Slide()
        }
        super.onCreate(savedInstanceState)
    }

    private fun sendOtp() {

        // validate your otp and send to server
        otpViewModel.validateNumber("mobile number").observe(this, Observer {

            // handle the response
        })

    }


}

