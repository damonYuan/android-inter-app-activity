package com.damonyuan.containing

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = applicationContext.getSharedPreferences("containing", 0)
        with (sharedPref.edit()) {
            putString(getString(R.string.MY_TESTING_KEY), "MY_TESTING_VALUE2")
            commit()
        }
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

}
