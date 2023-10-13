package com.example.islamyapp.ui.home.tabs.hadeath.hadeathdetails

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import com.example.islamyapp.R
import com.example.islamyapp.databinding.ActivityHadeathDetailsBinding
import com.example.islamyapp.ui.home.tabs.Consts
import com.example.islamyapp.ui.home.tabs.hadeath.HadeathItem

class HadeathDetails : AppCompatActivity() {
    lateinit var viewBinding:ActivityHadeathDetailsBinding
     private var hadeathItem:HadeathItem?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding= ActivityHadeathDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
       initParams()
        bindHadeath()
        viewBinding.back.setOnClickListener{
            finish()
        }

    }
    private fun initParams() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            hadeathItem = intent.getParcelableExtra(Consts.EXTRA_HADEATH,HadeathItem::class.java)
        }else {
            hadeathItem = intent.getParcelableExtra(Consts.EXTRA_HADEATH)as HadeathItem?
        }

    }

    private fun bindHadeath() {

        viewBinding.contentOfHadeath.text = hadeathItem?.hadeathContent
    }


}