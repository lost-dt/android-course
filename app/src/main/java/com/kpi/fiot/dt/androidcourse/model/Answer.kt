package com.kpi.fiot.dt.androidcourse.model

class Answer {
    var id: Int = 0
    var answerText: String? = null
    var questionText : String? = null
    var datetime: String? = null

    constructor() {}

    constructor(id: Int, answerText: String, questionText: String, timeStamp: String) {
        this.id = id
        this.answerText = answerText
        this.questionText = questionText
        this.datetime = timeStamp
    }
}
