package com.kpi.fiot.dt.androidcourse.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.kpi.fiot.dt.androidcourse.model.Answer


class DBHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "Answer.db"

    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(DBQueries.AnswerQueries.SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(DBQueries.AnswerQueries.SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    val allAnswer: List<Answer>
        @SuppressLint("Recycle")
        get() {
            val listAnswers = ArrayList<Answer>()

            val db: SQLiteDatabase = this.writableDatabase

            val cursor: Cursor = db.rawQuery(DBQueries.AnswerQueries.SQL_SELECT_ALL, null)

            if (cursor.moveToFirst()) {
                do {
                    val answer = Answer()
                    answer.id =
                        cursor.getInt(cursor.getColumnIndex(DBConstants.AnswerEntities.COLUMN_NAME_ID))
                    answer.answerText =
                        cursor.getString(cursor.getColumnIndex(DBConstants.AnswerEntities.COLUMN_NAME_ANSWER))
                    answer.questionText =
                        cursor.getString(cursor.getColumnIndex(DBConstants.AnswerEntities.COLUMN_NAME_QUESTION))
                    answer.datetime =
                        cursor.getString(cursor.getColumnIndex(DBConstants.AnswerEntities.COLUMN_NAME_DATETIME))

                    listAnswers.add(answer)
                } while (cursor.moveToNext())
            }
            db.close()
            return listAnswers
        }

    fun addAnswer(answer: Answer) {
        val db: SQLiteDatabase = this.writableDatabase

        val values = ContentValues()

        values.put(DBConstants.AnswerEntities.COLUMN_NAME_ID, answer.id)
        values.put(DBConstants.AnswerEntities.COLUMN_NAME_ANSWER, answer.answerText)
        values.put(DBConstants.AnswerEntities.COLUMN_NAME_QUESTION, answer.questionText)
        values.put(DBConstants.AnswerEntities.COLUMN_NAME_DATETIME, answer.datetime)

        db.insert(DBConstants.AnswerEntities.TABLE_NAME, null, values)
        db.close()

    }
}