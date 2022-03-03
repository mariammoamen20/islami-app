package com.example.islami.sebha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.islami.R

class SebhaFragment : Fragment() {
    lateinit var sebha_body_image: ImageView
    var counter: Int = 0
    lateinit var sebha_button: Button
    lateinit var azkar_text: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sebha, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sebha_body_image = view.findViewById(R.id.body_sebha_logo)
        sebha_button = view.findViewById(R.id.tasbehat_number_button)
        azkar_text = view.findViewById(R.id.azkar_text)
        sebha_button.text = "" + 0
        azkar_text.text = "سبحان الله "
        rotateImage()
    }

    private fun rotateImage() {
        sebha_body_image.setOnClickListener {
            val rotate_image_animation = RotateAnimation(
                0F,
                360F,
                RotateAnimation.RELATIVE_TO_SELF,
                .5f,
                RotateAnimation.RELATIVE_TO_SELF,
                .5f
            )
            rotate_image_animation.duration = 1000
            sebha_body_image.startAnimation(rotate_image_animation)
            counter++
            sebha_button.setText("" + counter)
            if (counter == 30) {
                azkar_text.setText("الحمد لله")
            }
            if (counter == 60) {
                azkar_text.setText("الله اكبر")
            }
            if (counter == 101) {
                azkar_text.text = "سبحان الله "
                counter = 0
            }
        }
    }

}

