package com.example.user.hw1.activity3_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.user.hw1.R
import com.example.user.hw1.activity3_fragments.tools.MapWorker
import java.io.*
import java.net.URL




class Main3Fragment : Fragment() {


    lateinit var plusSum: Button
    lateinit var minusSum: Button
    lateinit var list: ListView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val layout = inflater.inflate(R.layout.main3_fragment, container, false)

        var view: View = inflater.inflate(R.layout.main3_fragment, null)


        plusSum = view.findViewById(R.id.plusSum)
        minusSum = view.findViewById(R.id.minusSum)
        list = view.findViewById(R.id.list)

        var mylist:ArrayList<Map<String, Any>> = readFromFile()



        list.adapter = MapWorker().setAdapter(context, mylist)
        //list.onItemClickListener.onItemClick()


        plusSum.setOnClickListener {

                val fragment = AddSumFragment()
                activity.run {
                    val transaction = this!!.supportFragmentManager.beginTransaction()
                    transaction.add(R.id.fragment_container3, fragment)
                    transaction.commit()
                }


            }
        minusSum.setOnClickListener {

            val fragment = AddSumFragment()
            //fragment.arguments = Bundle() у фрагмента достать из bundle в стадии необходимую инфу
            activity.run {
                val transaction = this!!.supportFragmentManager.beginTransaction()
                transaction.add(R.id.fragment_container3, fragment)
                transaction.commit()
            }


        }

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


            return view



    }

    fun readFromFile():ArrayList<Map<String, Any>> {
        try {
            context!!.openFileInput("myList.list").use {
                val objectInput = ObjectInputStream(it)
                var list: ArrayList<Map<String, Any>> = objectInput.readObject() as ArrayList<Map<String, Any>>
                objectInput.close()
                return list
                //val file = InputStreamReader(context!!.openFileInput("myMap.map"))
                //val br = BufferedReader(file)
                //var line = br.readLine()
                //val all = StringBuilder()
                //while(line!= null){
                //all.append(line + "\n")
                //listItems.add(line)
                // line = br.readLine()


                //listItems.add(all.toString())
            }

        } catch (e: IOException) {
            Toast.makeText(context, "No data or corrupted data", Toast.LENGTH_LONG)
            return MapWorker().noMap()
        }

    }

    fun dataConstruct(line: String){


    }


}