package com.example.islamyapp.ui.home.tabs.sebha

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


import com.example.islamyapp.databinding.FragmentSebhaBinding

class SebhaFragment :Fragment() {
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
}