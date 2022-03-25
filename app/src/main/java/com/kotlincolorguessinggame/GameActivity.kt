package com.kotlincolorguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.TextView
import com.kotlincolorguessinggame.data.DataSource
import com.kotlincolorguessinggame.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding
    private var s = 0;
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.answer1.text = resources.getStringArray(DataSource().loadAnswerOptions()[0])[0]
        binding.answer2.text = resources.getStringArray(DataSource().loadAnswerOptions()[0])[1]
        binding.answer3.text = resources.getStringArray(DataSource().loadAnswerOptions()[0])[2]
    }

    fun answerButton(view: View) {
        val userAnswer = findViewById<TextView>(view.id).text.toString()

        if (userAnswer == resources.getString(DataSource().loadAnswers()[s])) {
            s += 1
            if (s == 10) s = 0

            binding.result.text = resources.getString(R.string.correct)
            binding.result.setTextColor(resources.getColor(R.color.green))
            binding.result.visibility = View.VISIBLE

            handler.postDelayed({
                binding.flowerImage.setImageResource(DataSource().loadFlowers()[s])
                binding.answer1.text =
                    resources.getStringArray(DataSource().loadAnswerOptions()[s])[0]
                binding.answer2.text =
                    resources.getStringArray(DataSource().loadAnswerOptions()[s])[1]
                binding.answer3.text =
                    resources.getStringArray(DataSource().loadAnswerOptions()[s])[2]
                binding.result.visibility = View.INVISIBLE
            }, 2000)
        } else {
            binding.result.text = resources.getString(R.string.incorrect)
            binding.result.setTextColor(resources.getColor(R.color.red))
            binding.result.visibility = View.VISIBLE

            handler.postDelayed({
                binding.result.visibility = View.INVISIBLE
            }, 1000)
        }
    }
}