package com.ffescara.myfinance

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ffescara.myfinance.data.Rate
import com.ffescara.myfinance.network.Api
import kotlinx.coroutines.launch

class KursViewModel : ViewModel() {

    var kursUiState: List<Rate> by mutableStateOf(listOf())

    init {
        //println("test")
        getKurs()
    }

    fun getKurs() {
        viewModelScope.launch {
            val response = Api.kursAPI.GetRates()
            val rate = response.rates

            rate.forEach { rate: Rate ->
                println(rate.toString())
                Log.d("Rates", rate.toString())
            }

            kursUiState = listOf(response.rates)
        }
    }

}