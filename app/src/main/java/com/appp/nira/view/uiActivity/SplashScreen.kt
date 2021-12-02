package com.appp.nira.view.uiActivity


import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.appp.nira.R
import com.appp.nira.viewDataModels.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreen : AppCompatActivity() {

    private val viewModel: SplashViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.splash_layout)


        viewModel.appSession.observe(this, Observer {

            if (it.data) {
                startActivity(Intent(this@SplashScreen, LoanCalculatorActivity::class.java))
            } else {
                startActivity(Intent(this@SplashScreen, OtpActivity::class.java))
            }
            finish()
        })

        /*lifecycleScope.launch(Dispatchers.Main) {
            delay(MS.toLong())
            if (viewModel.getSession) {
                startActivity(Intent(this@SplashScreen, LoanCalculatorActivity::class.java))
            } else {
                // start mobile otp screen
            }
            finish()
        }*/

    }
}