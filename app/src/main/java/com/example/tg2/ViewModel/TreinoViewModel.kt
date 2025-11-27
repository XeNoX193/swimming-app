package com.example.tg2.ViewModel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf

class TreinoViewModel : ViewModel() {
    val lapTimes = mutableStateListOf<Long>()
    fun setLapTimes(times: List<Long>) {
        lapTimes.clear()
        lapTimes.addAll(times)
    }
}