package com.kpi.fiot.dt.androidcourse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity:  AppCompatActivity(), QuestionFragment.QuestionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onButtonClick(selectedLanguages: String) {
        val answerFragment = supportFragmentManager.findFragmentById(R.id.answer_fragment) as AnswerFragment
        answerFragment.changeText(selectedLanguages)
    }

}
