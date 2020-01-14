package com.damonyuan.host

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.button.setOnClickListener {
            this.startHost()
        }
    }

    private fun startHost() {
        val intent = Intent()
        intent.action = "android.intent.action.MY_HOST_ACTION"
        intent.addCategory(Intent.CATEGORY_DEFAULT)
        startActivityForResult(intent, 10001)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 10001) {
            if (resultCode == Activity.RESULT_OK) {
                Log.d("MainActivity", "result ok")
            }
        }
    }
}
