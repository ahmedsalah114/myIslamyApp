package com.example.islamyapp.ui.home.tabs.hadeath

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamyapp.databinding.FragmentHadeathBinding
import com.example.islamyapp.ui.home.tabs.Consts
import com.example.islamyapp.ui.home.tabs.hadeath.hadeathdetails.HadeathDetails

class HadeathFragment :Fragment() {
    private lateinit var viewBinding: FragmentHadeathBinding
    lateinit var adapter: HadeathAdapter

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      viewBinding = FragmentHadeathBinding.inflate(inflater,container,false)
        return viewBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()

        adapter.onHadeathClickListener= object : HadeathAdapter.OnHadeathClickListener {
            override fun OnHadeathClick(item: HadeathItem, position: Int) {
                showHadeathDetails(item)
            }


        }
    }
    val ahadeathList = mutableListOf<HadeathItem>()
    override fun onStart() {
        super.onStart()
        readTheHadeathFiles()
        bindItems()
    }
    private fun showHadeathDetails(hadeath: HadeathItem) {
        val intent =Intent(requireContext(),HadeathDetails::class.java)
        intent.putExtra(Consts.EXTRA_HADEATH,hadeath)
        startActivity(intent)
    }
    private fun bindItems() {
        adapter.upDataData(ahadeathList)
    }
    private fun readTheHadeathFiles() {

        val fileContent = requireContext().assets.open("ahadeth.txt").bufferedReader().use{
            it.readText()}
        val hadeathContent =fileContent.trim().split("#")
        hadeathContent.forEach {
                val hadeath = it.trim().split("\n")
            var name = hadeath[0]
            var content =hadeath.joinToString("\n")
            ahadeathList.add(HadeathItem(name,content))
        }
    }
    private fun initRecyclerView() {
        adapter =HadeathAdapter(null)
        viewBinding.hadeathTitlesRv.adapter=adapter

    }
}