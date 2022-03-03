package com.example.islami.quran.suraname

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.Constant
import com.example.islami.R

class SuraNameActivity : AppCompatActivity() {
    lateinit var sura_name_title :TextView
    lateinit var sura_deatils:RecyclerView
    lateinit var sura_details_adapter : VerseAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_name)

        sura_name_title = findViewById(R.id.sura_name_title)
        sura_deatils = findViewById(R.id.sura_details_recycler_view)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val sura_name : String= intent.getStringExtra(Constant.ExTRA_SURA_NAME) as String
        val sura_position : Int = intent.getIntExtra(Constant.EXTRA_SURA_POSITION , -1)

        sura_details_adapter = VerseAdapter()
        sura_deatils.adapter = sura_details_adapter
        sura_name_title.setText(sura_name)

        readFileFormAsset(sura_position)
     }

     fun readFileFormAsset(position: Int) {
        val file_name = "${position+1}.txt"
        val file_content = assets.open(file_name).bufferedReader().use { it.readText() }
        val verses:List<String> = file_content.split("\n")
        sura_details_adapter.changeDate(verses)
    }
}