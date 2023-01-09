package com.metehanbolat.clipboardmanagerkotlin

import android.content.ClipboardManager
import android.content.Context
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ClipboardLD @Inject constructor(
    @ApplicationContext private val context: Context
) : MutableLiveData<String>() {

    private val clipBoardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

    override fun onActive() {
        super.onActive()
        postValue(clipBoardManager.primaryClip?.getItemAt(0)?.text.toString())
        clipboardListener
    }

    private val clipboardListener = ClipboardManager.OnPrimaryClipChangedListener {
        postValue(clipBoardManager.primaryClip?.getItemAt(0)?.text.toString())
    }

}