package com.example.islami.hadeath

import android.os.Bundle
import android.widget.Adapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.Constant
import com.example.islami.R
import java.text.FieldPosition

class HadeathDetailsActivity : AppCompatActivity() {
    lateinit var hadeath_title : TextView
    lateinit var hadeath_recycler_view : RecyclerView
    lateinit var hadeath_adapter:HadeathDetailsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hadeath_details)

        hadeath_title=findViewById(R.id.hadeth_details_text)
        hadeath_recycler_view = findViewById(R.id.hadeath_details_recycler_view)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val hadeath_name:String = intent.getStringExtra(Constant.EXTRA_HADEATH_NAME) as String
        val hadeath_postiton : Int = intent.getIntExtra(Constant.EXTRA_HADEATH_POSITION,-1)
        hadeath_title.setText(hadeath_name)
        hadeath_adapter = HadeathDetailsAdapter()
        hadeath_recycler_view.adapter = hadeath_adapter
        readHadeath(hadeath_postiton)
    }

    private fun readHadeath(position: Int) {

        val file_name = "${position+115}.txt"
        val file_content = assets.open(file_name).bufferedReader().use { it.readText() }
        val hadeath:List<String> = file_content.split("/n")
        hadeath_adapter.updateData(hadeath)
    }
}

