package com.kpi.fiot.dt.androidcourse

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onButtonClick(view: View) {
        val questionFragment = supportFragmentManager.findFragmentById(R.id.question_fragment) as QuestionFragment
        val questionResult = questionFragment.getSelectedLanguages()

        displayValues(questionResult)
    }

    private fun displayValues(question: String) {

        val answerFragment: AnswerFragment = AnswerFragment.newInstance(question)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.answer_fragment, answerFragment)
            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            commit()
        }

    }

}
