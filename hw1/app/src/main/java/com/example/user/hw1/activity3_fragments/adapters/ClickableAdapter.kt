package com.example.user.hw1.activity3_fragments.adapters

import android.content.Context
import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.user.hw1.Activity3
import com.example.user.hw1.R
import com.example.user.hw1.activity3_fragments.Main3Fragment
import com.example.user.hw1.activity3_fragments.tools.DataWorker
import com.example.user.hw1.activity3_fragments.tools.MapWorker
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlin.coroutines.experimental.coroutineContext

class ClickableAdapter(context: Context) : RecyclerView.Adapter<ClickableViewHolder>() {




    var list = DataWorker().readFromFile(context)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClickableViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ClickableViewHolder(
                inflater.inflate(R.layout.clickable_item, parent, false),
                ::onItemClick)

    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ClickableViewHolder, position: Int) {

        holder.setText(MapWorker().getTextFromMap(list, position) as String)
        holder.setSum(MapWorker().getSummFromMap(list, position) as String)
        holder.setIm(MapWorker().getImFromMap(list, position) as Int)


    }

    fun onItemClick(view: View, position: Int) {
        Toast.makeText(view.context, "Fragment will be avalible soon)", Toast.LENGTH_SHORT).show()
    }

}

class ClickableViewHolder(view : View,
                          private val clickListener : (View, Int) -> Unit ) : RecyclerView.ViewHolder(view) {
    private val sum: TextView = view.findViewById(R.id.listSum)
    private val text: TextView = view.findViewById(R.id.listText)
    private val im: ImageView = view.findViewById(R.id.listIm)

    init {
        view.setOnClickListener {
            clickListener(it, adapterPosition)
        }
    }

    fun setText(text : String) {
        this.text.text = text
    }

    fun setSum(sum : String) {
        this.sum.text = sum
    }
    fun setIm(im : Int) {
        this.im.setImageResource(im)
    }

}