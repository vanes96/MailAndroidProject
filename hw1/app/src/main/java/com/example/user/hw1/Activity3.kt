package com.example.user.hw1

import com.example.user.hw1.fragments.Fragment3
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity3.*

class Activity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity3)
        val fragment = Fragment3()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container3, fragment)
        transaction.addToBackStack("fragment3")
        transaction.commit()
    }
}
