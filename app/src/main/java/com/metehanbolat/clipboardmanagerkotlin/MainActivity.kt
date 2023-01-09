package com.metehanbolat.clipboardmanagerkotlin

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.metehanbolat.clipboardmanagerkotlin.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var clipboardLD: ClipboardLD

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        clipboardLD.observe(this) {
            println(it)
        }

        //viewModel.getClipboard(this)

        binding.button.setOnClickListener {
            println("Button: ${clipboardLD.value}")
        }

//        viewModel.clipData.observe(this) {
//            if (it == "Metehan") {
//                customDialog(it)
//            }
//        }

    }
    
    private fun customDialog(text: String) {
        val alertDialog = AlertDialog.Builder(this)
            .setTitle("Deneme")
            .setMessage("Bu bir text: $text")
            .create()
        alertDialog.show()
    }
}