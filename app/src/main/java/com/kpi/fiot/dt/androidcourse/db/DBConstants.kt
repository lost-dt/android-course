package com.kpi.fiot.dt.androidcourse.db

import android.provider.BaseColumns

object DBConstants {
    object AnswerEntities : BaseColumns {
        const val TABLE_NAME = "answer"
        const val COLUMN_NAME_ID = "id"
        const val COLUMN_NAME_QUESTION = "question"
        const val COLUMN_NAME_ANSWER = "answer"
        const val COLUMN_NAME_DATETIME = "datetime"
    }
}
