package com.bugrakaragozoglu.pickin

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()
        val timer = object: CountDownTimer(3000, 1000) {

            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {
                val intent= Intent(this@SplashScreen,MainActivity::class.java)
                startActivity(intent)
            }
        }
        timer.start()
    }
}