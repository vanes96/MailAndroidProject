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
            writeToFile(addSum.text.toString(), addText.text.toString(), "mydata.txt", 1)

        }


        ///data/user/0/com.example.user.hw1/files/mydata.txt
        //fun getJson():String {

        //var content = URL("http://www.cbr-xml-daily.ru/daily_json.js").readText()

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


    fun writeToFile(sum: String, text: String, filename: String, ind:Int) {
        try {
            var context = context
            var list:ArrayList<Map<String, Any>>
            try {
                val fileInput = context!!.openFileInput("myList.list")
                val objectInput = ObjectInputStream(fileInput)
                list = objectInput.readObject() as ArrayList<Map<String, Any>>
                objectInput.close()

                //val file = InputStreamReader(context!!.openFileInput("myMap.map"))
                //val br = BufferedReader(file)
                //var line = br.readLine()
                //val all = StringBuilder()
                //while(line!= null){
                //all.append(line + "\n")
                //listItems.add(line)
                // line = br.readLine()



                //listItems.add(all.toString())


            } catch (e: IOException) {
                list = MapWorker().noMap()
                Toast.makeText(context, "No data or corrupted data", Toast.LENGTH_LONG)
            }
            context!!.openFileOutput("myList.list", Context.MODE_PRIVATE).use {
                //val fileOutput = FileOutputStream("myList.list")
                val objectOuput = ObjectOutputStream(it)
                objectOuput.writeObject(MapWorker().addToMap(list, sum, text))
                objectOuput.close()
            }

        }
        catch (e: IOException){
            print(e)

        }

        //context!!.openFileOutput(filename, Context.MODE_PRIVATE).use {
            //it.write(("startBlock_"+ "StartOfSum_"+sum + "_endOfSum_").toByteArray())
            //it.write(("startOfText_"+text + "_endOfText_"+"endBlock;").toByteArray())
            //it.close()



    }
}