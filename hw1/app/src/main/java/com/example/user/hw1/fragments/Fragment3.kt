package com.example.user.hw1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.user.hw1.R
import org.json.JSONException
import org.json.JSONObject
import org.json.JSONTokener
import java.lang.StringBuilder
import java.net.URL


class Fragment3 : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view : View = inflater.inflate(R.layout.fragment3, null)

        var text: TextView = view.findViewById(R.id.textView)

        //fun getJson():String {

            var content = URL("http://www.cbr-xml-daily.ru/daily_json.js").readText()

            //val jtk = JSONTokener(content)
            //try {
                //val jsonObject = jtk.nextValue() as JSONObject
                //val builder = StringBuilder()
                //for (key in jsonObject.keys()) {
                //    builder.append("$key : ${jsonObject.get(key)}").append("\n")
                //}
                //return builder.toString()
            //} catch (ex: JSONException){
                //ex.printStackTrace()
                //return ""
            //}
        //}

        text.setText(content)



        return view

    }

}