package com.appp.nira.view.uiActivity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.appp.nira.R
import com.appp.nira.databinding.ActivityLoanBinding
import com.appp.nira.models.LoanPlannerModel
import com.appp.nira.utils.Constant.updateFormat
import com.appp.nira.viewDataModels.LoanCalculatorViewModel
import com.google.android.material.slider.Slider
import com.skydoves.bindables.BindingActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.roundToInt

@AndroidEntryPoint
class LoanCalculatorActivity :
    BindingActivity<ActivityLoanBinding>(R.layout.activity_loan)/*AppCompatActivity()*/ {

    private val loanCalculatorViewModel: LoanCalculatorViewModel by viewModels()

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeUI()
    }

    private fun initializeUI() {


        findViewById<Slider>(R.id.amountSlider).apply {

            setLabelFormatter { value: Float ->
                return@setLabelFormatter "${value.roundToInt()}"
            }

            addOnChangeListener(Slider.OnChangeListener { slider, value, fromUser ->
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
                loanCalculatorViewModel.updateTenure(value.toInt()).observe(
                    this@LoanCalculatorActivity, androidx.lifecycle.Observer {

                        updateView(it.data)


                    })
            })
        }


        loanCalculatorViewModel.loanData.observe(
            this@LoanCalculatorActivity, androidx.lifecycle.Observer {

                updateView(it.data)


            })

        binding.viewLogButton.setOnClickListener {
            startActivity(Intent(this@LoanCalculatorActivity, ApplyActivity::class.java))
            finish()

        }

    }

    private fun updateView(loanPlannerModel: LoanPlannerModel) {

        with(binding) {

            amountSlider.apply {
                stepSize = loanPlannerModel.loanMover.toFloat()
                value = loanPlannerModel.defaultLoanAmount.toFloat()
                valueFrom = loanPlannerModel.loanLowerLimit.toFloat()
                valueTo = loanPlannerModel.loanUpperLimit.toFloat()
            }
            loanUpperLimit.text = updateFormat(loanPlannerModel.loanUpperLimit)
            loanLowerLimit.text = updateFormat(loanPlannerModel.loanLowerLimit)
            tenureSlider.apply {
                stepSize = loanPlannerModel.tenurMover.toFloat()
                value = loanPlannerModel.tenurDefault.toFloat()
                valueFrom = loanPlannerModel.tenureMin.toFloat()
                valueTo = loanPlannerModel.tenureMax.toFloat()
            }

            tenureLowerLimit.text = loanPlannerModel.tenureMin.toString()
            tenureUpperLimit.text = loanPlannerModel.tenureMax.toString()

            loanAmount.text = "Loan Amt ${updateFormat(loanPlannerModel.defaultLoanAmount)}"
            loanTenure.text = "Tensure ${loanPlannerModel.tenurDefault}"
            val amount =
                (loanPlannerModel.amount + loanPlannerModel.interest) / loanPlannerModel.tenurDefault
            totalLoan.text = "${updateFormat(amount)}"
            interest.text = "Interest @ ${loanPlannerModel.interest}% per month"

        }

    }
}

