package com.sample.albertson_coding_challenge.view

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.sample.albertson_coding_challenge.databinding.ActivityMainBinding
import com.sample.albertson_coding_challenge.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    lateinit var context: Context

    private lateinit var binding: ActivityMainBinding

    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        context = this@MainActivity

        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        /*  mainActivityViewModel.getUser()!!.observe(this) { serviceSetterGetter ->

                val msg = serviceSetterGetter.message

            }
            */

    }
}
