package com.example.user.hw1.activity3_fragments.tools

import android.content.Context
import android.widget.SimpleAdapter
import android.widget.Toast
import com.example.user.hw1.R
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class DataWorker {
    fun readFromFile(context: Context):ArrayList<Map<String, Any>> {
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
    fun writeToFile(context: Context, sum: String, text: String, filename: String, ind:Int, state:Boolean) {
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
                objectOuput.writeObject(MapWorker().addToMap(list, sum, text, state))
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