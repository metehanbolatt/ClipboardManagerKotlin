package com.metehanbolat.clipboardmanagerkotlin


import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.metehanbolat.clipboardmanagerkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel.getClipboard(this)

        viewModel.clipData.observe(this) {
            if (it == "Metehan") {
                customDialog(it)
            }
        }

    }

    private fun customDialog(iban: String) {
        val alertDialog = AlertDialog.Builder(this)
            .setTitle("Deneme")
            .setMessage("Bu bir iban: $iban")
            .create()
        alertDialog.show()
    }
}