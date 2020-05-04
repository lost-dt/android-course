package com.kpi.fiot.dt.androidcourse.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kpi.fiot.dt.androidcourse.R
import kotlinx.android.synthetic.main.quick_answer_fragment.*

class QuickAnswerFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.quick_answer_fragment, container, false)
    }

    fun changeText(selectedLanguages: String) {
        selectedLanguagesOutput.text = selectedLanguages
    }

}
