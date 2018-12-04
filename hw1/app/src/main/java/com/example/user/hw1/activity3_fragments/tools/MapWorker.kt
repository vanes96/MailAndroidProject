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
    val ATTRIBURE_NAME_STATE:String = "state"
    val positive:Int = android.R.drawable.arrow_up_float
    val negative:Int = android.R.drawable.arrow_down_float
    fun addToMap(data: ArrayList<Map<String, Any>>, summ:String, text:String, state:Boolean):ArrayList<Map<String, Any>>{
        var m:Map<String, Any>
        m = HashMap<String, Any>()
        var img:Int = 0
        if(state){ img = positive
        }
        else{ img = negative

        }
        m.put(ATTRIBUTE_NAME_TEXT, text)
        m.put(ATTRIBUTE_NAME_SUMM, summ)
        m.put(ATTRIBUTE_NAME_IMAGE, img)
        m.put(ATTRIBURE_NAME_STATE, state)
        data.add(m)
        return data
    }
    fun noMap():ArrayList<Map<String, Any>>{
        var data = ArrayList<Map<String, Any>>()
        var m = HashMap<String, Any>()
        m.put(ATTRIBUTE_NAME_TEXT, "")
        m.put(ATTRIBUTE_NAME_SUMM, "0")
        m.put(ATTRIBUTE_NAME_IMAGE, 0)
        m.put(ATTRIBURE_NAME_STATE, true)
        data.add(m)
        return data

    }
    fun getTextFromMap(data: ArrayList<Map<String, Any>>, position: Int):Any{
        var m:Map<String, Any>
        return data.get(position).get(ATTRIBUTE_NAME_TEXT)!!
    }
    fun getSummFromMap(data: ArrayList<Map<String, Any>>, position: Int):Any{
        var m:Map<String, Any>
        return data.get(position).get(ATTRIBUTE_NAME_SUMM)!!
    }
    fun getImFromMap(data: ArrayList<Map<String, Any>>, position: Int):Any{
        var m:Map<String, Any>
        return data.get(position).get(ATTRIBUTE_NAME_IMAGE)!!
    }

    fun getTotal(data: ArrayList<Map<String, Any>>):String{
        var s:Int = 0
        for (i in data){
            if(i.get(ATTRIBURE_NAME_STATE) as Boolean)
            s = s.plus(i.get(ATTRIBUTE_NAME_SUMM).toString().toInt())
            else   s = s.minus(i.get(ATTRIBUTE_NAME_SUMM).toString().toInt())
        }
        return s.toString()
    }


}