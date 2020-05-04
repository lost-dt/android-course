package com.kpi.fiot.dt.androidcourse.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.kpi.fiot.dt.androidcourse.R

class QuestionFragment: Fragment() {

    var activityCallback: QuestionListener? = null
    interface QuestionListener {
        fun receiveAnswer(selectedLanguages: String)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.question_fragment, container, false)

        val button: Button? = view?.findViewById(R.id.bt_submit)
        button?.setOnClickListener { _: View -> getSelectedLanguages()}

        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            activityCallback = context as QuestionListener
        } catch (e: ClassCastException) {
            throw ClassCastException(context?.toString()
                    + " must implement QuestionListener")
        }
    }

    private fun getSelectedLanguages() {
        val checkBoxScala = view?.findViewById<CheckBox>(R.id.cd_scala)
        val checkBoxJava = view?.findViewById<CheckBox>(R.id.cd_java)
        val checkBoxPython = view?.findViewById<CheckBox>(R.id.cd_python)
        val checkBoxR = view?.findViewById<CheckBox>(R.id.cd_r)

        validateInput()

        var result = ArrayList<String>()
        if(checkBoxScala!!.isChecked){
            result.add("Scala")
        }
        if(checkBoxJava!!.isChecked){
            result.add("Java")
        }
        if(checkBoxPython!!.isChecked){
            result.add("Python")
        }
        if(checkBoxR!!.isChecked){
            result.add("R")
        }

        activityCallback?.receiveAnswer(result.joinToString(separator = ","))
    }

    private fun validateInput() {
        val checkBoxScala = view?.findViewById<CheckBox>(R.id.cd_scala)
        val checkBoxJava = view?.findViewById<CheckBox>(R.id.cd_java)
        val checkBoxPython = view?.findViewById<CheckBox>(R.id.cd_python)
        val checkBoxR = view?.findViewById<CheckBox>(R.id.cd_r)
        if(!checkBoxScala!!.isChecked and !checkBoxJava!!.isChecked
                and !checkBoxPython!!.isChecked and !checkBoxR!!.isChecked) {
            Toast.makeText(activity,
                R.string.error_message, Toast.LENGTH_LONG).show()
        }
    }
}
