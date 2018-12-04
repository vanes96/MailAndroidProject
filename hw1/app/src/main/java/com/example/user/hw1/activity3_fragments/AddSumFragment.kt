package com.example.user.hw1.activity3_fragments

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.user.hw1.R
import com.example.user.hw1.activity3_fragments.tools.DataWorker
import com.example.user.hw1.activity3_fragments.tools.MapWorker
import java.io.*

import java.net.URL




class AddSumFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {



        var view: View = inflater.inflate(R.layout.add_sum_fragment, null)

        var addSum: EditText = view.findViewById(R.id.addSum)
        var addText: EditText = view.findViewById(R.id.addText)
        var addButton: Button = view.findViewById(R.id.addButton)


        val filename = "mydata.txt"


        addButton.setOnClickListener {
            DataWorker().writeToFile(context!!, addSum.text.toString(), addText.text.toString(), "mydata.txt", 1, arguments!!.getBoolean("sum"))

        }





        return view

    }





}