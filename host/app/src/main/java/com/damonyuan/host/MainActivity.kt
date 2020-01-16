package com.damonyuan.host

import android.app.Activity
import android.content.ActivityNotFoundException
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
        try {
            startActivityForResult(intent, 10001)
        } catch (e: ActivityNotFoundException) {
            // either the containing app is not installed or the version doesn't meet
            // the minimum requirement.
            // here we can redirect the user to Play Store/website to download/upgrade
            // the containing app.
            Log.e("MainActivity", "Fail to found the activity")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 10001) {
            if (resultCode == Activity.RESULT_OK) {
                Log.d("MainActivity", "result ok")
            }
        }
    }
}
