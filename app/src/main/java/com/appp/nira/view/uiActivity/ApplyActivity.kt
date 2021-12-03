package com.appp.nira.view.uiActivity

import android.content.Intent
import android.os.Bundle
import android.transition.Slide
import android.view.Window
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.appp.nira.R
import com.appp.nira.databinding.ApplyLayoutBinding
import com.appp.nira.utils.Constant.numberOfItemToBeOverlapped
import com.appp.nira.utils.Constant.overlapWidthInPercentage
import com.appp.nira.view.adapter.RecyclerViewAdapter
import com.appp.nira.viewDataModels.ApplyViewModel
import com.mindinventory.overlaprecylcerview.animations.OverlapRecyclerViewAnimation
import com.skydoves.bindables.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ApplyActivity :
    BindingActivity<ApplyLayoutBinding>(R.layout.apply_layout)/*AppCompatActivity()*/ {

    private val applyViewModel: ApplyViewModel by viewModels()

    private val userImageAdapter by lazy {
        RecyclerViewAdapter(numberOfItemToBeOverlapped, overlapWidthInPercentage)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        with(window) {
            requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)

            // set an exit transition
            exitTransition = Slide()
        }
        super.onCreate(savedInstanceState)
        initializeUI()
        loadList()
    }

    private fun loadList() {

        applyViewModel.loadUserList.observe(this, Observer {

            userImageAdapter.addAll(it.data)

        })
    }

    private fun initializeUI() {

        with(binding) {
            recyclerView.apply {
                addItemDecoration(userImageAdapter.getItemDecoration())
            }
            userImageAdapter.addAnimation = true
            userImageAdapter.animationType = OverlapRecyclerViewAnimation.RIGHT_LEFT
            userAdapter = userImageAdapter
        }



        binding.applyButton.setOnClickListener {
            applyViewModel.saveActivityState().observe(this, Observer {

                if (it.data) {
                    startActivity(Intent(this@ApplyActivity, OtpActivity::class.java))
                    finish()

                }
            })
        }


    }


}

