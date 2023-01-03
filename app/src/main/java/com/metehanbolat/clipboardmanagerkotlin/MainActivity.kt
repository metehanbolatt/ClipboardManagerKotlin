package com.metehanbolat.clipboardmanagerkotlin

import android.content.ClipDescription.MIMETYPE_TEXT_PLAIN
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.metehanbolat.clipboardmanagerkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //val clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        val clipboard2 = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

        binding.button.setOnClickListener {
            //println("text: ${clipboard.setPrimaryClip(ClipData.newPlainText("Deneme", "Text"))}")
            if (clipboard2.primaryClipDescription!!.hasMimeType(MIMETYPE_TEXT_PLAIN)) {
                val item = clipboard2.primaryClip!!.getItemAt(0)
                val yourText = item.text.toString()
                binding.textView.text = "MyText: $yourText"
                println("My text: $yourText")
            }
        }

    }
}