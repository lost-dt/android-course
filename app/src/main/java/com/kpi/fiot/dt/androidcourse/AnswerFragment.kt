package com.kpi.fiot.dt.androidcourse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

const val TEXT_KEY = ""

class AnswerFragment: Fragment() {
    val displayText: String by lazy {
        arguments?.getString(TEXT_KEY) ?: ""
    }

    companion object {
        fun newInstance(composedText: String): AnswerFragment {
            val fragment = AnswerFragment()

            val args = Bundle()
            args.putString(TEXT_KEY, composedText)

            fragment.arguments = args

            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.answer_fragment, container, false)
        val output = view.findViewById<TextView>(R.id.output)
        output.text = displayText

        return view
    }

}