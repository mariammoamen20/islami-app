package com.example.islami.radio

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.islami.R
import com.example.islami.api.ApiManger
import com.example.islami.api.RadioResponse
import com.example.islami.api.RadiosItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RadioFragment : Fragment() {

    lateinit var radio_channel_name: TextView
    lateinit var play_button: ImageView
    lateinit var previous_button: ImageView
    lateinit var next_button: ImageView
    lateinit var progress_bar: ProgressBar
    lateinit var item_radio_lits: ArrayList<RadiosItem>
    var position = 100
    var media_player = MediaPlayer()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_radio, container, false)
    }

    override fun onStop() {
        super.onStop()
        if(media_player.isPlaying){
            media_player.stop()
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //function to initialize views
        initViews()

        getDataFromApi()
    }

    fun getDataFromApi() {
        ApiManger.getApi().getRadiosChannel().enqueue(object : Callback<RadioResponse> {
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun onResponse(call: Call<RadioResponse>, response: Response<RadioResponse>) {
                //Log.e("onResponse" , response.body().toString())
                item_radio_lits = response.body()?.radios as ArrayList<RadiosItem>
                radio_channel_name.text = item_radio_lits[0].name


            }

            override fun onFailure(call: Call<RadioResponse>, t: Throwable) {
            }
        })
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun playSound(i: Int) {
        val url = item_radio_lits[i].uRL
        media_player = MediaPlayer().apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
            setDataSource(url)
            prepareAsync()
        }
        media_player.setOnPreparedListener {
            progress_bar.isVisible = false
            media_player.start()
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun initViews() {
        radio_channel_name = requireView().findViewById(R.id.radio_channel)
        play_button = requireView().findViewById(R.id.icon_play)
        previous_button = requireView().findViewById(R.id.icon_previous)
        next_button = requireView().findViewById(R.id.icon_next)
        progress_bar = requireView().findViewById(R.id.progress_bar)

        clickListeners()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun clickListeners() {
        play_button.setOnClickListener {

            if (!media_player.isPlaying) {

                playSound(position)
                play_button.setImageResource(R.drawable.ic_paus)
                media_player.isPlaying

            }
            if (media_player.isPlaying) {
                !media_player.isPlaying
                play_button.setImageResource(R.drawable.ic_play)
                media_player.stop()
            }
        }
        next_button.setOnClickListener {
            position++
            radio_channel_name.text = item_radio_lits[position].name

            if (media_player.isPlaying) {
                play_button.setImageResource(R.drawable.ic_paus)
                media_player.stop()
            }
            playSound(position)
        }
        previous_button.setOnClickListener {
            position--;

            radio_channel_name.text = item_radio_lits[position].name
            if (media_player.isPlaying) {
                play_button.setImageResource(R.drawable.ic_paus)
                media_player.stop()
            }
            playSound(position)


        }

    }
}