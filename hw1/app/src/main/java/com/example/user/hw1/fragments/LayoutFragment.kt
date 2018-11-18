package com.example.user.hw1.fragments

import android.app.Fragment
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.lang.IllegalStateException

class LayoutFragment : Fragment() {
    companion object {
        const val LAYOUT_KEY = "LAYOUT_KEY"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val args = arguments
        args?.run {
            val layout = getInt(LAYOUT_KEY)
            return inflater.inflate(layout, container, false)
        }
        throw IllegalStateException("There must be layout!!!")
    }
}