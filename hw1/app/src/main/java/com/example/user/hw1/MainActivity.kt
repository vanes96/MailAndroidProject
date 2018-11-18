package com.example.user.hw1

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.PersistableBundle

import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    lateinit var timer : CountDownTimer
    var onTimer = false

    private var time : Long = 0
    fun createTimer(sec:Long): CountDownTimer{
        val timer = object : CountDownTimer(sec, 1000) {
            override fun onTick(p0: Long) {
                time = 5000.minus(p0)
            }

            override fun onFinish() {
                timer.cancel()
                onTimer = false
                val intent =Intent(this@MainActivity, Main2Activity::class.java)
                startActivity(intent)
                this@MainActivity.finish()
            }

        }
        return timer
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            onTimer = savedInstanceState.getBoolean("timerOn")
            timer = createTimer(5000.minus(savedInstanceState.getLong("timeSec")))
            if (onTimer == false) {
                timer.start()
                onTimer = true
            }
        }
        else{
            timer = createTimer(5000)
            if (onTimer == false) {
                timer.start()
                onTimer = true
            }
        }


    }


    override fun onSaveInstanceState(outState: Bundle) {

        onTimer = false
        outState.putLong("timeSec", time)
        outState.putBoolean("timerOn", onTimer)
        timer.cancel()

        super.onSaveInstanceState(outState)
    }






}
