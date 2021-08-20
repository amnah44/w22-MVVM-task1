package com.amnah.currencyconverter.model.repository

import com.amnah.currencyconverter.model.domain.Currency

class MainRepository {

    fun getConvertCurrency(currency: Currency, input: Double): Double {
        return when (currency) {
            Currency.IQD -> input * 1460
            Currency.USD -> input / 1460
        }

    }

}