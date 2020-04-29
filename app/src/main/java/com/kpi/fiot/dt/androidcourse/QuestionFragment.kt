package com.kpi.fiot.dt.androidcourse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast
import androidx.fragment.app.Fragment

class QuestionFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.question_fragment, container, false)
    }

    fun getSelectedLanguages(): String {
        val checkBoxScala = view?.findViewById<CheckBox>(R.id.cd_scala)
        val checkBoxJava = view?.findViewById<CheckBox>(R.id.cd_java)
        val checkBoxPython = view?.findViewById<CheckBox>(R.id.cd_python)
        val checkBoxR = view?.findViewById<CheckBox>(R.id.cd_r)

        validateInput()

        var result = ""
        if(checkBoxScala!!.isChecked){
            result += "\n Scala"
        }
        if(checkBoxJava!!.isChecked){
            result += "\n Java"
        }
        if(checkBoxPython!!.isChecked){
            result += "\n Python"
        }
        if(checkBoxR!!.isChecked){
            result += "\n R"
        }

        return result
    }

    private fun validateInput() {
        val checkBoxScala = view?.findViewById<CheckBox>(R.id.cd_scala)
        val checkBoxJava = view?.findViewById<CheckBox>(R.id.cd_java)
        val checkBoxPython = view?.findViewById<CheckBox>(R.id.cd_python)
        val checkBoxR = view?.findViewById<CheckBox>(R.id.cd_r)
        if(!checkBoxScala!!.isChecked and !checkBoxJava!!.isChecked
                and !checkBoxPython!!.isChecked and !checkBoxR!!.isChecked) {
            Toast.makeText(activity, R.string.error_message, Toast.LENGTH_LONG).show()
        }
    }
}
