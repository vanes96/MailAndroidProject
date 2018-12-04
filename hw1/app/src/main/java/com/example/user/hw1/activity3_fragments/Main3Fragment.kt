package com.example.user.hw1.activity3_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.user.hw1.R
import com.example.user.hw1.activity3_fragments.adapters.ClickableAdapter
import com.example.user.hw1.activity3_fragments.tools.DataWorker
import com.example.user.hw1.activity3_fragments.tools.MapWorker
import com.example.user.hw1.activity3_fragments.tools.Rate
import com.google.gson.GsonBuilder
import java.io.*
import java.net.URL




class Main3Fragment : Fragment() {


    lateinit var plusSum: Button
    lateinit var minusSum: Button
    lateinit var list: RecyclerView
    lateinit var total: TextView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val layout = inflater.inflate(R.layout.main3_fragment, container, false)

        var view: View = inflater.inflate(R.layout.main3_fragment, null)


        plusSum = view.findViewById(R.id.plusSum)
        minusSum = view.findViewById(R.id.minusSum)
        list = view.findViewById(R.id.recView)
        total = view.findViewById(R.id.textView)
        total.setText(MapWorker().getTotal(DataWorker().readFromFile(context!!)))

        var mylist:ArrayList<Map<String, Any>> = DataWorker().readFromFile(context!!)



        val layoutManager = LinearLayoutManager(
                requireContext(),
                RecyclerView.VERTICAL,
                false
        )


        list.layoutManager = layoutManager
        list.adapter = ClickableAdapter(context!!)



        plusSum.setOnClickListener {

                val fragment = AddSumFragment()
            val args = Bundle()
            args.putBoolean("sum", true)
            fragment.arguments = args
                activity.run {
                    val transaction = this!!.supportFragmentManager.beginTransaction()
                    transaction.add(R.id.fragment_container3, fragment)
                    transaction.commit()
                }


            }
        minusSum.setOnClickListener {

            val fragment = AddSumFragment()
            val args = Bundle()
            args.putBoolean("sum", false)
            fragment.arguments = args

            activity.run {
                val transaction = this!!.supportFragmentManager.beginTransaction()
                transaction.add(R.id.fragment_container3, fragment)
                transaction.commit()
            }


        }



        var content = URL("http://www.cbr-xml-daily.ru/daily_json.js").readText()
        val builder = GsonBuilder()
        val gson = builder.create()
        val Rate = gson.fromJson(content, Rate::class.java)
        Toast.makeText(context, Rate.valute!!.usd!!.value.toString(), Toast.LENGTH_LONG).show()



            return view



    }






}