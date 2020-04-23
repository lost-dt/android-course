package com.kpi.fiot.dt.androidcourse

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val checkBoxScala = findViewById<CheckBox>(R.id.cd_scala)
        val checkBoxJava = findViewById<CheckBox>(R.id.cd_java)
        val checkBoxPython = findViewById<CheckBox>(R.id.cd_python)
        val checkBoxR = findViewById<CheckBox>(R.id.cd_r)

        val buttonSubmit = findViewById<Button>(R.id.bt_submit)
        val textViewOutput = findViewById<TextView>(R.id.output)

        checkBoxScala.setOnClickListener(View.OnClickListener {

            if(checkBoxScala.isChecked) {
                checkBoxScala.setTextColor(getColor(R.color.colorAccent))
            } else {
                checkBoxScala.setTextColor(getColor(R.color.colorBlack))
            }
        })
        checkBoxJava.setOnClickListener(View.OnClickListener {

            if(checkBoxJava.isChecked) {
                checkBoxJava.setTextColor(getColor(R.color.colorAccent))
            } else {
                checkBoxJava.setTextColor(getColor(R.color.colorBlack))
            }
        })
        checkBoxPython.setOnClickListener(View.OnClickListener {

            if(checkBoxPython.isChecked) {
                checkBoxPython.setTextColor(getColor(R.color.colorAccent))
            } else {
                checkBoxPython.setTextColor(getColor(R.color.colorBlack))
            }
        })
        checkBoxR.setOnClickListener(View.OnClickListener {

            if(checkBoxR.isChecked) {
                checkBoxR.setTextColor(getColor(R.color.colorAccent))
            } else {
                checkBoxR.setTextColor(getColor(R.color.colorBlack))
            }
        })

        buttonSubmit.setOnClickListener(View.OnClickListener {

            if(!checkBoxScala.isChecked and !checkBoxJava.isChecked
                and !checkBoxPython.isChecked and !checkBoxR.isChecked){
                val warningMessage = "Enter your answer please"
                textViewOutput.setText(warningMessage)
                textViewOutput.setTextColor(getColor(R.color.colorRed))
            } else {
                var result = ""

                if(checkBoxScala.isChecked){
                    result += "\n Scala"
                }
                if(checkBoxJava.isChecked){
                    result += "\n Java"
                }
                if(checkBoxPython.isChecked){
                    result += "\n Python"
                }
                if(checkBoxR.isChecked){
                    result += "\n R"
                }

                textViewOutput.setText(result)
                textViewOutput.setTextColor(getColor(R.color.colorPrimaryDark))
            }
        })

    }
}
