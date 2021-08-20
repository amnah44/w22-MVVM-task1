package com.amnah.currencyconverter.model.repository

import com.amnah.currencyconverter.model.domain.Currency
import com.amnah.currencyconverter.util.Constant.Companion.CONVERTER_NUMBER

class MainRepository {

    fun getConvertCurrency(currency: Currency, input: Double): Double {
        return when (currency) {
            Currency.IQD -> input * CONVERTER_NUMBER
            Currency.USD -> input / CONVERTER_NUMBER
        }

    }

}