package com.example.quizapp

import android.util.Log

/*data?*/ class Quiz (val questions: List <Question>){
    companion object{
        val TAG = "Quiz"
    }
    public var score = 0
    private var currentQuestionNum = 0
    public fun initializeQuestionText() : String{
        return questions[currentQuestionNum].currentQuestion
    }
    public fun initializeOptions(): List<String>{
        val list = arrayListOf<String>()
        list.add (questions[currentQuestionNum].option1)
        list.add (questions[currentQuestionNum].option2)
        list.add (questions[currentQuestionNum].option3)
        list.add (questions[currentQuestionNum].option4)
        return list
    }
    public fun isCorrect(text:CharSequence): Boolean
    {
        Log.d(TAG, "isCorrect outside code block: $score")
        if(text == questions[currentQuestionNum].currentAnswer)
        {
            //this code block may not be being called
            score++
            Log.d(TAG, "isCorrect inside code block: $score")
        }
        return text == questions[currentQuestionNum].currentAnswer
    }
    public fun addToCurrentQuestionNum(){
        currentQuestionNum++
    }
    //variables to track score, current questio
    //function to check if there's another question
    //give the next question, check the answer
}