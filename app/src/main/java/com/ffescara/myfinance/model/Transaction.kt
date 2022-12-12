package com.ffescara.myfinance.model

import androidx.annotation.StringRes

class Transaction(
    @StringRes val textResourceId: Int,
    @StringRes val categoryResourceId: Int
)