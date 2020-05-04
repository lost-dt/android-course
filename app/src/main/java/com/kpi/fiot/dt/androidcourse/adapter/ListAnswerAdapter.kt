package com.kpi.fiot.dt.androidcourse.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.kpi.fiot.dt.androidcourse.R
import com.kpi.fiot.dt.androidcourse.model.Answer
import kotlinx.android.synthetic.main.row_answer_fragment.view.*

class ListAnswerAdapter(activity: Activity, private var listAnswer: List<Answer>): BaseAdapter() {

    private val inflater: LayoutInflater =
        activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView: View = inflater.inflate(R.layout.row_answer_fragment, null)

        rowView.row_answer_id.text = listAnswer[position].id.toString()
        rowView.row_answer_text.text = listAnswer[position].answerText
        rowView.row_answer_timestamp.text = listAnswer[position].datetime

        return rowView
    }

    override fun getItem(position: Int): Any {
        return listAnswer[position]
    }

    override fun getItemId(position: Int): Long {
        return listAnswer[position].id.toLong()
    }

    override fun getCount(): Int {
        return listAnswer.size
    }
}