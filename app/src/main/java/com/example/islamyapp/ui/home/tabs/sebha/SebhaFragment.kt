package com.example.islamyapp.ui.home.tabs.sebha

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


import com.example.islamyapp.databinding.FragmentSebhaBinding
import com.example.islamyapp.ui.home.tabs.Consts
import kotlin.math.roundToInt

class SebhaFragment :Fragment() {
    var counter =0
    lateinit var viewBinding: FragmentSebhaBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      viewBinding = FragmentSebhaBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.content.text=Consts.ALHAMD_LLAH
        viewBinding.counter.text=counter.toString()

        viewBinding.ivBody.setOnClickListener  {
            onClick()
        }
    }
var tasbeh=0
    private fun onClick() {
        counter++
        if (counter ==33)
        {
            tasbeh++
        }
        when (tasbeh){

            1 -> {

                viewBinding.content.text=Consts.ALAH_AKBAR
                viewBinding.counter.text=counter.toString()
            counter =0
                returnTransition

            }
            2->{

                viewBinding.content.text=Consts.SOBHAN_ALAH
                viewBinding.counter.text=counter.toString()
                return onClick()

            }
        }
        viewBinding.ivBody.rotation=viewBinding.ivBody.rotation+20
        viewBinding.counter.text=counter.toString()
    }
}