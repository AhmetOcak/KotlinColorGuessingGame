package com.kotlincolorguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.kotlincolorguessinggame.data.DataSource
import com.kotlincolorguessinggame.databinding.ActivityGameBinding
import com.kotlincolorguessinggame.databinding.ActivityMainBinding

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding
    private var s = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun answerButton(view: View) {
        binding.flowerImage.setImageResource(DataSource().loadFlowers()[s])
        s +=1
        if(s == 10) s = 0
    }
}