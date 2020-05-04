package com.kpi.fiot.dt.androidcourse.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.kpi.fiot.dt.androidcourse.R
import com.kpi.fiot.dt.androidcourse.db.DBHelper
import com.kpi.fiot.dt.androidcourse.fragment.QuickAnswerFragment
import com.kpi.fiot.dt.androidcourse.fragment.QuestionFragment
import com.kpi.fiot.dt.androidcourse.model.Answer
import java.time.Instant
import java.time.format.DateTimeFormatter


class MainActivity : AppCompatActivity(), QuestionFragment.QuestionListener {

    internal lateinit var db: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = DBHelper(this)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun receiveAnswer(selectedLanguages: String) {
        val answerFragment =
            supportFragmentManager.findFragmentById(R.id.quick_answer_fragment) as QuickAnswerFragment
        answerFragment.changeText(selectedLanguages)

        if (selectedLanguages.isNotEmpty()) {
            val answer = Answer(
                id = (0..1000).random(),
                answerText = selectedLanguages,
                questionText = R.string.favorite_language_message.toString(),
                timeStamp = DateTimeFormatter.ISO_INSTANT.format(Instant.now()).toString()
            )

            db.addAnswer(answer)
        }
    }

    fun displayHistory(view: View) {
        val intent = Intent(this, AnswerHistoryActivity::class.java)
        startActivity(intent)
    }
}
