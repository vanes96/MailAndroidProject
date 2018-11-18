package com.example.user.hw1.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.user.hw1.R
import com.example.user.hw1.Router
import com.example.user.hw1.list.ButtonsListAdapter

class MainFragment : Fragment() {

    private lateinit var router : Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        router = Router(requireActivity(), R.id.fragment_container)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layout = inflater.inflate(R.layout.fragment_main, container, false)
        val buttons : RecyclerView = layout.findViewById(R.id.buttons)
        buttons.layoutManager = LinearLayoutManager(
                inflater.context,
                RecyclerView.VERTICAL,
                false
        )
        buttons.adapter = ButtonsListAdapter(createButtons(), ::onButtonClick)
        return layout
    }
    private fun createButtons() : Array<String> {
        return arrayOf(
                "one",
                "two",
                "three",
                "four",
                "five"
        )
    }
    private fun onButtonClick(position : Int) = when(position) {
        0 -> router.navigateTo { getLayoutFragment(R.layout.fragment1) }
        1 -> router.navigateTo { getLayoutFragment(R.layout.fragment2) }
        2 -> router.navigateTo { getLayoutFragment(R.layout.fragment3) }
        3 -> router.navigateTo { getLayoutFragment(R.layout.fragment4) }
        4 -> router.navigateTo {getLayoutFragment(R.layout.fragment5)}

        else -> throw IllegalStateException()
    }

    }
    private fun getLayoutFragment(layout : Int) : Fragment {
        val fragment = LayoutFragment()
        val args = Bundle()
        args.putInt(LayoutFragment.LAYOUT_KEY, layout)
        fragment.arguments = args
        return fragment
    }

