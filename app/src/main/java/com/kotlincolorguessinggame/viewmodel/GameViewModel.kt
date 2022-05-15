package com.kotlincolorguessinggame.viewmodel

import android.app.Application
import android.graphics.drawable.Drawable
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kotlincolorguessinggame.R
import com.kotlincolorguessinggame.data.DataSource

class GameViewModel(application: Application) : AndroidViewModel(application) {

    private val _resultText = MutableLiveData<String>()
    val resultText: LiveData<String> get() = _resultText

    private val _resultTextVisibility = MutableLiveData<Int>()
    val resultTextVisibility: LiveData<Int> get() = _resultTextVisibility

    private val _resultTextColor = MutableLiveData<Int>()
    val resultTextColor: LiveData<Int> get() = _resultTextColor

    private val _image = MutableLiveData<Drawable>()
    val image: LiveData<Drawable> get() = _image

    private val _answer1 = MutableLiveData<String>()
    val answer1: LiveData<String> get() = _answer1

    private val _answer2 = MutableLiveData<String>()
    val answer2: LiveData<String> get() = _answer2

    private val _answer3 = MutableLiveData<String>()
    val answer3: LiveData<String> get() = _answer3

    private val userAnswer = MutableLiveData<String>()

    private var s = 0;
    private val handler = Handler(Looper.getMainLooper())

    init {
        initData()
    }

    fun checkAnswer(view: View) {
        val button = view as Button
        userAnswer.value = button.text.toString()

        if (userAnswer.value == getApplication<Application>().getString(DataSource().loadAnswers()[s])) {
            setData(true)
            delay(true)
        } else {
            setData(false)
            delay(false)
        }
    }

    private fun initData() {
        _answer1.value =
            getApplication<Application>().resources.getStringArray(DataSource().loadAnswerOptions()[0])[0]
        _answer2.value =
            getApplication<Application>().resources.getStringArray(DataSource().loadAnswerOptions()[0])[1]
        _answer3.value =
            getApplication<Application>().resources.getStringArray(DataSource().loadAnswerOptions()[0])[2]
        _image.value = getApplication<Application>().getDrawable(DataSource().loadFlowers()[0])
    }

    private fun delay(isCorrect: Boolean) {
        if (isCorrect) {
            handler.postDelayed({
                _image.value =
                    getApplication<Application>().getDrawable(DataSource().loadFlowers()[s])
                _answer1.value =
                    getApplication<Application>().resources.getStringArray(DataSource().loadAnswerOptions()[s])[0]
                _answer2.value =
                    getApplication<Application>().resources.getStringArray(DataSource().loadAnswerOptions()[s])[1]
                _answer3.value =
                    getApplication<Application>().resources.getStringArray(DataSource().loadAnswerOptions()[s])[2]
                _resultTextVisibility.value = View.INVISIBLE
            }, 1000)
        } else {
            handler.postDelayed({
                _resultTextVisibility.value = View.INVISIBLE
            }, 1000)
        }
    }

    private fun setData(isCorrect: Boolean) {
        if (isCorrect) {
            s += 1
            if (s == 10) s = 0

            _resultText.value = getApplication<Application>().getString(R.string.correct)
            _resultTextColor.value = getApplication<Application>().getColor(R.color.green)
            _resultTextVisibility.value = View.VISIBLE
        } else {
            _resultText.value = getApplication<Application>().getString(R.string.incorrect)
            _resultTextColor.value = getApplication<Application>().getColor(R.color.red)
            _resultTextVisibility.value = View.VISIBLE
        }
    }
}