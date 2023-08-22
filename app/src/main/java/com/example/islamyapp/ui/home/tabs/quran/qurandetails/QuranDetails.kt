package com.example.islamyapp.ui.home.tabs.quran.qurandetails
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.islamyapp.databinding.ActivityQuranDetailsBinding
import com.example.islamyapp.ui.home.tabs.Consts

class QuranDetails : AppCompatActivity() {
    lateinit var binding: ActivityQuranDetailsBinding
    lateinit var name:String
    lateinit var suraNumber:String
    lateinit var adapter: VersesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding =ActivityQuranDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.back.setOnClickListener {
            finish()
        }
        getIntentContent()
        adapter=VersesAdapter(null)
        readTheContent()
        binding.suraRv.adapter=adapter
    }
    private fun readTheContent(){
        val fileContent = application.assets.open("$suraNumber.txt").bufferedReader().use{
            it.readText()}
        val verseList =fileContent.trim().split("\n")
        adapter.upDate(verseList)
    }
    private fun getIntentContent(){
        name = intent.getStringExtra(Consts.CONST_NAME_OF_SORA).toString()
        suraNumber =intent.getStringExtra(Consts.CONST_NUMBER_OF_SORA).toString()
        binding.nameofsora.text = name
    }
}
