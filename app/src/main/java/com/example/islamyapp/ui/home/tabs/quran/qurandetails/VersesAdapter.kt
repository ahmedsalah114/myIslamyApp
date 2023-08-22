package com.example.islamyapp.ui.home.tabs.quran.qurandetails

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamyapp.R

class VersesAdapter (private var list: List<String>?=null):Adapter<VersesAdapter.VersesViewHolder>() {

    class VersesViewHolder (val view: View):ViewHolder(view){
      val  verseTextView:TextView =view.findViewById(R.id.verse_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VersesViewHolder {
        val view =LayoutInflater.from(parent.context)
            .inflate(R.layout.item_verse_content,parent,false)
        return VersesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: VersesViewHolder, position: Int) {

        holder.verseTextView.text= list?.get(position)
    }
    @SuppressLint("NotifyDataSetChanged")
    fun upDate(list: List<String>?){
        this.list=list
        notifyDataSetChanged()
    }
}