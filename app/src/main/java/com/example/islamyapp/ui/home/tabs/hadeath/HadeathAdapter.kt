package com.example.islamyapp.ui.home.tabs.hadeath

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamyapp.R

class HadeathAdapter(var list: List<HadeathItem>?=null) :RecyclerView.Adapter<HadeathAdapter.HadeathViewHolder>(){
    class HadeathViewHolder (val view: View):RecyclerView.ViewHolder(view){
       val hadeathTitleText:TextView =view.findViewById(R.id.elhadeath_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadeathViewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hadeath_name,parent,false)
        return HadeathViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: HadeathViewHolder, position: Int) {
        val item =list?.get(position)
        holder.hadeathTitleText.text=item?.name
        holder.view.setOnClickListener{
            onHadeathClickListener?.OnHadeathClick(HadeathItem(),position)
        }
    }

    fun upDataData(hadeathList: MutableList<HadeathItem>) {
        list=hadeathList
        notifyDataSetChanged()
    }

    var onHadeathClickListener:OnHadeathClickListener ?=null
    fun interface OnHadeathClickListener{
        fun OnHadeathClick(item: HadeathItem , position: Int)
    }
}