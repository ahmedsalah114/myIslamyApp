package com.example.islamyapp.ui.home.tabs.radio

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamyapp.databinding.FragmentHadeathBinding
import com.example.islamyapp.databinding.FragmentQuranBinding
import com.example.islamyapp.databinding.FragmentRadioBinding

class RadioFragment :Fragment() {
    lateinit var viewBinding: FragmentRadioBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      viewBinding = FragmentRadioBinding.inflate(inflater,container,false)
        return viewBinding.root
    }
}