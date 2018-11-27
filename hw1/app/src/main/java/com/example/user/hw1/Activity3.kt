package com.example.user.hw1

import com.example.user.hw1.fragments.Fragment3
import android.os.Bundle
import android.os.StrictMode
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.user.hw1.activity3_fragments.AddSumFragment
import com.example.user.hw1.activity3_fragments.Main3Fragment
import kotlinx.android.synthetic.main.activity3.*
import org.json.JSONException
import org.json.JSONObject
import org.json.JSONTokener
import java.lang.StringBuilder
import java.net.URL

class Activity3 : AppCompatActivity() {


    var currentSum: Int =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val policy : StrictMode.ThreadPolicy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        setContentView(R.layout.activity3)
        val fragment = Main3Fragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container3, fragment)
        transaction.commit()


        //val fragment = Fragment3()
        //val transaction = supportFragmentManager.beginTransaction()
        //transaction.replace(R.id.fragment_container3, fragment)
        //transaction.addToBackStack("fragment3")
        //transaction.commit()
    }
    fun simplefun(){

    }


}
