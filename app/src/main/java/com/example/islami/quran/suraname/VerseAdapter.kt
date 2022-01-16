package com.example.islami.quran.suraname

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R

class VerseAdapter() : RecyclerView.Adapter<VerseAdapter.VerseViewHolder>(){
    var item_list : List<String>?=null
    class VerseViewHolder(item_view : View) : RecyclerView.ViewHolder(item_view){
        val verse_details : TextView = item_view.findViewById(R.id.verse_details)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.verse_item,parent,false)
        return VerseViewHolder(view)
    }

    override fun onBindViewHolder(holder: VerseViewHolder, position: Int) {
        val items : String? = item_list?.get(position)
        holder.verse_details.text = items
    }

    override fun getItemCount(): Int = item_list?.size ?:0

    fun changeDate(verse : List<String>){
        this.item_list = verse
        notifyDataSetChanged()
    }
}