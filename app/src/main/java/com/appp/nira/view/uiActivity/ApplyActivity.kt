package com.appp.nira.view.uiActivity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
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

    private val userAdapter by lazy {
        RecyclerViewAdapter(numberOfItemToBeOverlapped, overlapWidthInPercentage)
    }

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeUI()
        loadList()
    }

    private fun loadList() {

        applyViewModel.loadUserList.observe(this, Observer {

            userAdapter.addAll(it.data)

        })
    }

    private fun initializeUI() {

        binding.recyclerView.apply {
            addItemDecoration(userAdapter.getItemDecoration())
            adapter = userAdapter
            userAdapter.addAnimation = true
            userAdapter.animationType = OverlapRecyclerViewAnimation.LEFT_RIGHT
        }



        binding.applyButton.setOnClickListener {
            applyViewModel.saveActivityState().observe(this, Observer {

                if(it.data){

                    startActivity(Intent(this@ApplyActivity, OtpActivity::class.java))
                    finish()

                }
            })
        }


    }


}

