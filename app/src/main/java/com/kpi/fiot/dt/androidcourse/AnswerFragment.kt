package com.kpi.fiot.dt.androidcourse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.answer_fragment.*

class AnswerFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.answer_fragment, container, false)
    }

    fun changeText(selectedLanguages: String) {
        selectedLanguagesOutput.text = selectedLanguages
    }

}
