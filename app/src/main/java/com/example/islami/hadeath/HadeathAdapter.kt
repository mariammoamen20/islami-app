package com.example.islami.hadeath

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R

class HadeathAdapter(val list_item : List<String>) : RecyclerView.Adapter<HadeathAdapter.HadeathViewHolder>(){
    class HadeathViewHolder(item_view : View) : RecyclerView.ViewHolder(item_view){
        val hadeath_text : TextView = item_view.findViewById(R.id.hadeath_number_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadeathViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.hadeath_item,parent,false)
        return HadeathViewHolder(view)
    }

    override fun onBindViewHolder(holder: HadeathViewHolder, position: Int) {
      holder.hadeath_text.setText(list_item[position])
        if(on_item_click_listener!=null){
            holder.itemView.setOnClickListener {
                on_item_click_listener?.onItemClick(position,list_item[position])
            }
        }
    }

    override fun getItemCount(): Int = list_item.size
    var on_item_click_listener:OnItemClickListener?=null
    interface OnItemClickListener{
        fun onItemClick(position: Int,name : String)
    }
    }

