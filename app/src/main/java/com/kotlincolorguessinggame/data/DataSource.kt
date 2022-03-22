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
}