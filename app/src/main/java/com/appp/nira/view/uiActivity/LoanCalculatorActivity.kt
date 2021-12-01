package com.appp.nira.view.uiActivity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import com.appp.nira.R
import com.appp.nira.databinding.ActivityLoanBinding
import com.appp.nira.viewDataModels.LoanCalculatorViewModel
import com.skydoves.bindables.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoanCalculatorActivity :
    BindingActivity<ActivityLoanBinding>(R.layout.activity_loan)/*AppCompatActivity()*/ {

    private val loanCalculatorViewModel: LoanCalculatorViewModel by viewModels()

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loan)
        initializeUI()
    }

    private fun initializeUI() {
        with(binding) {
            viewModel = loanCalculatorViewModel
        }
    }
}