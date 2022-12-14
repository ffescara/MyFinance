package com.ffescara.myfinance.data

data class Rate(
    val EUR: Number,
    val USD: Number,
    val JPY: Number,
    val BGN: Number,
    val CZK: Number,
    val DKK: Number,
    val GBP: Number,
    val HUF: Number,
    val PLN: Number,
    val RON: Number,
    val SEK: Number,
    val CHF: Number,
    val ISK: Number,
    val NOK: Number,
    val HRK: Number,
    val TRY: Number,
    val AUD: Number,
    val BRL: Number,
    val CAD: Number,
    val CNY: Number,
    val HKD: Number,
    val IDR: Number,
    val ILS: Number,
    val INR: Number,
    val KRW: Number,
    val MXN: Number,
    val MYR: Number,
    val NZD: Number,
    val PHP: Number,
    val SGD: Number,
    val THB: Number,
    val ZAR: Number,
) {
    fun forEach(function: (Rate) -> Int) {

    }
}