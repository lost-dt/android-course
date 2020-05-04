package com.kpi.fiot.dt.androidcourse.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kpi.fiot.dt.androidcourse.R
import com.kpi.fiot.dt.androidcourse.adapter.ListAnswerAdapter
import com.kpi.fiot.dt.androidcourse.db.DBHelper
import com.kpi.fiot.dt.androidcourse.model.Answer
import kotlinx.android.synthetic.main.activity_answer_history.*

@SuppressLint("Registered")
class AnswerHistoryActivity : AppCompatActivity() {

    internal lateinit var db: DBHelper
    internal var listAnswer: List<Answer> = ArrayList<Answer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer_history)

        db = DBHelper(this)
        refreshHistory()
    }

    private fun refreshHistory() {
        listAnswer = db.allAnswer

        val adapter = ListAnswerAdapter(this@AnswerHistoryActivity, listAnswer)
        answer_history.adapter = adapter

        if (listAnswer.isEmpty()) {
            Toast.makeText(
                this,
                R.string.empty_database, Toast.LENGTH_LONG
            ).show()
        }
    }

}
