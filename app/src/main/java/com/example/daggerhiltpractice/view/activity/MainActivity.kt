package com.example.daggerhiltpractice.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.daggerhiltpractice.databinding.ActivityMainBinding
import com.example.daggerhiltpractice.viewModel.MainViewModel
import com.example.daggerhiltpractice.utils.ScreenState
import com.example.daggerhiltpractice.utils.logData
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        viewModel.viewModelScope.launch {
            val mutableLiveData = viewModel.getCharacterFromRemote("1")
            mutableLiveData.observe(this@MainActivity) {
                when (it) {
                    is ScreenState.Loading -> {
                        logData("onCreate: its loading")
                    }
                    is ScreenState.Error -> {
                        logData("onCreate: loading done")
                        logData("onCreate: networkError with message=${it.message}")
                    }
                    is ScreenState.Success -> {
                        logData("onCreate: loading done")
                        logData("onCreate: response=${it.data}")
                        it.data?.let { it1 -> viewModel.saveDataToDatabase(it1) }
                    }
                }
            }
        }
    }

}