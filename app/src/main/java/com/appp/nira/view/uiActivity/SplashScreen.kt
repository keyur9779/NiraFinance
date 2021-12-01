package com.appp.nira.view.uiActivity


import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.appp.nira.R
import com.appp.nira.utils.Constant.MS
import com.appp.nira.viewDataModels.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashScreen : AppCompatActivity() {

    private val viewModel: SplashViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.splash_layout)


        lifecycleScope.launch(Dispatchers.Main) {
            delay(MS.toLong())
            if (viewModel.getSession) {
                startActivity(Intent(this@SplashScreen, LoanCalculatorActivity::class.java))
            } else {
                // start mobile otp screen
            }
            finish()
        }

    }
}