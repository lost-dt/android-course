package com.kpi.fiot.dt.androidcourse.db

object DBQueries {

    object AnswerQueries {
        const val SQL_CREATE_ENTRIES =
            "CREATE TABLE ${DBConstants.AnswerEntities.TABLE_NAME} (" +
                    "${DBConstants.AnswerEntities.COLUMN_NAME_ID} INTEGER PRIMARY KEY," +
                    "${DBConstants.AnswerEntities.COLUMN_NAME_QUESTION} TEXT," +
                    "${DBConstants.AnswerEntities.COLUMN_NAME_ANSWER} TEXT," +
                    "${DBConstants.AnswerEntities.COLUMN_NAME_DATETIME} TEXT)"

        const val SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS ${DBConstants.AnswerEntities.TABLE_NAME}"

        const val SQL_SELECT_ALL = "SELECT * FROM ${DBConstants.AnswerEntities.TABLE_NAME}"
    }
}
