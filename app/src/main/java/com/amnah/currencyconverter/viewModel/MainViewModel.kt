package com.amnah.currencyconverter.viewModel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.amnah.currencyconverter.model.domain.Currency
import com.amnah.currencyconverter.model.repository.MainRepository

class MainViewModel : ViewModel() {

    val converterResult: MediatorLiveData<String?> = MediatorLiveData()

    val editTextIQD: MediatorLiveData<String?> = MediatorLiveData()

    val editTextUSD: MediatorLiveData<String?> = MediatorLiveData()

    private val repository = MainRepository()

    private val mediatorToDinar = MediatorLiveData<String?>().apply {
        addSource(editTextUSD) { value ->
            setValue(value)
            setConverterFromUDSToIQD()

        }
        addSource(editTextIQD) { value ->
            setValue(value)
            setConverterFromIQDToUSD()
        }
    }.also { it.observeForever { converterResult } }

    private fun setConverterFromUDSToIQD() = converterResult.postValue("${
        editTextUSD.value?.toDoubleOrNull()?.let {
            repository.getConvertCurrency(Currency.IQD, it)
        }
    } ")

    private fun setConverterFromIQDToUSD() = converterResult.postValue(
        "${
            editTextIQD.value?.toDoubleOrNull()?.let {
                repository.getConvertCurrency(Currency.USD, it)
            }?.toFloat()
        }"
    )

}