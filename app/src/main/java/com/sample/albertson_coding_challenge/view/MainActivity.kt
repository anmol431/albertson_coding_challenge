package com.sample.albertson_coding_challenge.view

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.sample.albertson_coding_challenge.R
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

        binding.lifecycleOwner = this

        context = this@MainActivity

        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        binding.btnSearch.setOnClickListener {
            hideKeyboard()
            binding.isLoading = true
            mainActivityViewModel.getUser(binding.edtAbbreviation.text.toString())!!
                .observe(this) { acromineData ->
                    if (acromineData.size > 0) {
                        binding.tvResultAcromine.text = String.format(
                            getString(R.string.result_acromine_text),
                            acromineData[0].sf
                        )

                        if (acromineData[0].lfs?.isNotEmpty() == true) {
                            binding.rcvMain.adapter = acromineData[0].lfs?.let { LfsListAdapter(it.asList()) }
                        }
                        binding.isDataFound = true
                        binding.tvError.visibility = View.GONE
                    } else {
                        binding.isDataFound = false
                        binding.tvError.visibility = View.VISIBLE
                    }
                    binding.isLoading = false
                }
        }
    }

    private fun hideKeyboard() {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }
}
