package com.metehanbolat.retrofitwithsuspendfunctions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.metehanbolat.retrofitwithsuspendfunctions.databinding.ActivityMainBinding
import com.metehanbolat.retrofitwithsuspendfunctions.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.getPost()

        viewModel.myResponse.observe(this) { response ->
            if (response.isSuccessful) {
                response?.let {
                    println(it.body()!!.id)
                    println(it.body()!!.userId)
                    println(it.body()!!.title)
                    println(it.body()!!.body)
                    binding.textView.text = it.body()!!.title
                }
            }else {
                println(response.errorBody())
                binding.textView.text = response.code().toString()
            }
        }
    }
}