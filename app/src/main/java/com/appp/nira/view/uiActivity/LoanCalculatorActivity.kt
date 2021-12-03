package com.appp.nira.view.uiActivity

import android.content.Intent
import android.os.Bundle
import android.transition.Slide
import android.util.Log
import android.view.Window
import androidx.activity.viewModels
import com.appp.nira.R
import com.appp.nira.databinding.ActivityLoanBinding
import com.appp.nira.models.LoanPlannerModel
import com.appp.nira.viewDataModels.LoanCalculatorViewModel
import com.google.android.material.slider.Slider
import com.skydoves.bindables.BindingActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.roundToInt

@AndroidEntryPoint
class LoanCalculatorActivity :
    BindingActivity<ActivityLoanBinding>(R.layout.activity_loan)/*AppCompatActivity()*/ {

    private val loanCalculatorViewModel: LoanCalculatorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        with(window) {
            requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)

            // set an exit transition
            exitTransition = Slide()
        }
        super.onCreate(savedInstanceState)
        initializeUI()
    }

    private fun initializeUI() {


        loanCalculatorViewModel.loanData.observe(
            this@LoanCalculatorActivity, androidx.lifecycle.Observer {

                updateView(it.data)


                findViewById<Slider>(R.id.amountSlider).apply {

                    setLabelFormatter { value: Float ->
                        return@setLabelFormatter "${value.roundToInt()}"
                    }

                    addOnChangeListener(Slider.OnChangeListener { slider, value, fromUser ->

                        if (!fromUser) {
                            return@OnChangeListener
                        }
                        loanCalculatorViewModel.updateAmount(value.toInt()).observe(
                            this@LoanCalculatorActivity, androidx.lifecycle.Observer {


                                updateView(it.data)

                            })

                    })
                }

                findViewById<Slider>(R.id.tenureSlider).apply {

                    setLabelFormatter { value: Float ->
                        return@setLabelFormatter "${value.roundToInt()}"
                    }

                    addOnChangeListener(Slider.OnChangeListener { slider, value, fromUser ->

                        if (!fromUser) {
                            return@OnChangeListener
                        }
                        loanCalculatorViewModel.updateTenure(value.toInt()).observe(
                            this@LoanCalculatorActivity, androidx.lifecycle.Observer {

                                updateView(it.data)


                            })
                    })
                }
            })

        binding.viewLogButton.setOnClickListener {
            startActivity(Intent(this@LoanCalculatorActivity, ApplyActivity::class.java))
            finish()

        }

    }

    private fun updateView(model: LoanPlannerModel) {

        if(model == null){

            Log.d("keyur","whyy thi si snukk");
        }

        with(binding) {

            loanPlannerModel = model

        }

    }
}

