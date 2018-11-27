package com.example.user.hw1.activity3_fragments.tools

import android.content.Context
import android.widget.SimpleAdapter
import com.example.user.hw1.R
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class MapWorker {
    val ATTRIBUTE_NAME_TEXT:String = "text"
    val ATTRIBUTE_NAME_SUMM:String = "summ"
    val ATTRIBUTE_NAME_IMAGE:String = "image"
    val positive:Int = android.R.drawable.arrow_up_float
    val negative:Int = android.R.drawable.arrow_down_float
    fun addToMap(data: ArrayList<Map<String, Any>>, summ:String, text:String):ArrayList<Map<String, Any>>{
        var m:Map<String, Any>
        m = HashMap<String, Any>()
        var img:Int = 0
        m.put(ATTRIBUTE_NAME_TEXT, text)
        m.put(ATTRIBUTE_NAME_SUMM, summ)
        if(summ.toInt()>0) img = positive
        else img = negative
        m.put(ATTRIBUTE_NAME_IMAGE, img)
        data.add(m)
        return data
    }
    fun noMap():ArrayList<Map<String, Any>>{
        var data = ArrayList<Map<String, Any>>()
        var m = HashMap<String, Any>()
        m.put(ATTRIBUTE_NAME_TEXT, "")
        m.put(ATTRIBUTE_NAME_SUMM, "")
        m.put(ATTRIBUTE_NAME_IMAGE, 0)
        data.add(m)
        return data

    }
    fun setAdapter(context: Context?, mylist:ArrayList<Map<String, Any>>):SimpleAdapter{
        var from= arrayOf(ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_SUMM, ATTRIBUTE_NAME_IMAGE)
        var to =IntArray(3)
        to.set(0, R.id.listText)
        to.set(1, R.id.listSum)
        to.set(2, R.id.listIm)
        return SimpleAdapter(context, mylist, R.layout.main3_fragment_list, from, to)
    }

}