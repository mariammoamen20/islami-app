package com.example.islami.hadeath

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R

class HadeathDetailsAdapter :RecyclerView.Adapter<HadeathDetailsAdapter.HadeathViewHolder>(){
    var items:List<String>?=null
    class HadeathViewHolder(item_view:View) : RecyclerView.ViewHolder(item_view){
        val hadeaht_details:TextView = item_view.findViewById(R.id.hadeat_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadeathViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.hadeath_details_item,parent,false)
        return HadeathViewHolder(view)
    }

    override fun onBindViewHolder(holder: HadeathViewHolder, position: Int) {
       val item :String? = items?.get(position)
        holder.hadeaht_details.setText(item)
    }

    override fun getItemCount(): Int {
        return items?.size ?:0
    }
    fun updateData(hadeath : List<String>){
        this.items=hadeath
        notifyDataSetChanged()
    }
}