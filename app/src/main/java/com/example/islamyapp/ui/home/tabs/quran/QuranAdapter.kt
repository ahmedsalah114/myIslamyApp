package com.example.islamyapp.ui.home.tabs.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamyapp.R

class QuranAdapter (val list: List<QuranItem>):RecyclerView.Adapter<QuranAdapter.SuraNameViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuraNameViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.item_sora_name,parent,false)
        return SuraNameViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SuraNameViewHolder, position: Int) {
        val item = list[position]
        holder.soraName.text = item.soraName
        holder.soraNumber.text = item.soraNumber
        holder.itemView.setOnClickListener {
        onSoraClickListener?.onSuraClick(item)
    }

    }
    class SuraNameViewHolder (private var view: View): RecyclerView.ViewHolder(view){
        val soraName:TextView =view.findViewById(R.id.name_of_sora)
        val soraNumber:TextView =view.findViewById(R.id.number_of_sora)

    }
    var onSoraClickListener:OnSoraClickListener?=null
    interface OnSoraClickListener{
        fun onSuraClick(quranItem:QuranItem)
    }

}