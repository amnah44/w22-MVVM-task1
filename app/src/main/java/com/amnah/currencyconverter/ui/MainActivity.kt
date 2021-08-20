package com.amnah.currencyconverter.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.amnah.currencyconverter.R
import com.amnah.currencyconverter.databinding.ActivityMainBinding
import com.amnah.currencyconverter.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding

    private val _viewModel: MainViewModel by viewModels()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        _binding.viewModel = _viewModel
        _binding.lifecycleOwner = this

    }

}