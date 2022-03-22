package com.kotlincolorguessinggame.data

import com.kotlincolorguessinggame.R

class DataSource {
    fun loadFlowers():List<Int> {
        return listOf<Int>(
            R.drawable.flower1,
            R.drawable.flower2,
            R.drawable.flower3,
            R.drawable.flower4,
            R.drawable.flower5,
            R.drawable.flower6,
            R.drawable.flower7,
            R.drawable.flower8,
            R.drawable.flower9,
            R.drawable.flower10
        )
    }
    fun loadAnswers():List<Int> {
        return listOf<Int>(
            R.string.answer1,
            R.string.answer2,
            R.string.answer3,
            R.string.answer4,
            R.string.answer5,
            R.string.answer6,
            R.string.answer7,
            R.string.answer8,
            R.string.answer9,
            R.string.answer10
        )
    }
    fun loadAnswerOptions():List<Int> {
        return listOf<Int>(
            R.array.question1,
            R.array.question2,
            R.array.question3,
            R.array.question4,
            R.array.question5,
            R.array.question6,
            R.array.question7,
            R.array.question8,
            R.array.question9,
            R.array.question10,
        )
    }

}