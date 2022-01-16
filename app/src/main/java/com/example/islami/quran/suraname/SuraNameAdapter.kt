package com.example.islami.quran.suraname

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R

class SuraNameAdapter(val item_list : List<String>):RecyclerView.Adapter<SuraNameAdapter.QuranViewHolder>() {
   class QuranViewHolder(item_view:View):RecyclerView.ViewHolder(item_view){
       val suran_name_text : TextView= item_view.findViewById(R.id.sura_name_text)
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuranViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.quran_suran_name_item,parent,false)
        return QuranViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuranViewHolder, position: Int) {
        holder.suran_name_text.setText(item_list[position])
        if(on_item_click_listner!=null){
           holder.itemView.setOnClickListener {
               on_item_click_listner?.onItemClick(position,item_list[position])
           }
        }
    }

    override fun getItemCount(): Int {
        return item_list.size
    }
    var on_item_click_listner : OnItemClickListener?=null
    interface OnItemClickListener{
        fun onItemClick(position: Int , item:String)
    }
}