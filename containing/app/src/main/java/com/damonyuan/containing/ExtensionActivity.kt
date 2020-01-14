package com.damonyuan.containing

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_extension.*

class ExtensionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extension)
        Log.d("ExtensionActivity", "launch")
        this.button.setOnClickListener {
            action()
        }
    }

    private fun action() {
        setResult(Activity.RESULT_OK)
        finish()
    }
}