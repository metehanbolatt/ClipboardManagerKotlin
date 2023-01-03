package com.metehanbolat.clipboardmanagerkotlin

import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _clipData = MutableLiveData<String>()
    val clipData: LiveData<String> = _clipData

    fun getClipboard(context: Context) {
        val clipBoardManager = context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        _clipData.value = clipBoardManager.primaryClip?.getItemAt(0)?.text?.toString()
        clipBoardManager.addPrimaryClipChangedListener {
            _clipData.value = clipBoardManager.primaryClip?.getItemAt(0)?.text?.toString()
        }
    }
}