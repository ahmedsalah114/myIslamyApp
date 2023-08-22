package com.example.islamyapp.ui.home.tabs.quran

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamyapp.databinding.FragmentQuranBinding
import com.example.islamyapp.ui.home.tabs.Consts
import com.example.islamyapp.ui.home.tabs.quran.qurandetails.QuranDetails

class QuranFragment :Fragment() {
    lateinit var viewBinding: FragmentQuranBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      viewBinding = FragmentQuranBinding.inflate(inflater,container,false)
        return viewBinding.root
    }
    lateinit var adapter: QuranAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        adapter.onSoraClickListener=object :QuranAdapter.OnSoraClickListener{
            override fun onSuraClick(quranItem: QuranItem) {
                val intent = Intent(requireContext(), QuranDetails::class.java)
                intent.putExtra(Consts.CONST_NAME_OF_SORA,quranItem.soraName)
                intent.putExtra(Consts.CONST_NUMBER_OF_SORA,quranItem.soraNumber)
                startActivity(intent)
0            }

        }



    }

    private fun initRecyclerView() {
        adapter = QuranAdapter(arSuras.mapIndexed() {index ,it ->
            QuranItem(soraName = it, soraNumber = "${index+1}" )
        })
        viewBinding.quranRv.adapter=adapter
    }

}