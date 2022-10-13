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
        Log.d(TAG, "isCorrect outside text: " +text+ " answer:" +  questions[currentQuestionNum].currentAnswer)
        if(text.equals(questions[currentQuestionNum].currentAnswer))
        {
            //this code block may not be being called
            score++
            Log.d(TAG, "isCorrect inside code block / score : $score currentQuestion: $currentQuestionNum")
        }
        if(text != questions[currentQuestionNum].currentAnswer)
        {
            Log.d(TAG,"isCorrect 'is not correct' code block/ score : $score currentQuestion: $currentQuestionNum" )
        }
        return text == questions[currentQuestionNum].currentAnswer
    }
    public fun addToCurrentQuestionNum(){
        currentQuestionNum++
    }

    fun isThereNextQuestion():Boolean {
        return currentQuestionNum < questions.size
    }
    //variables to track score, current question
    //function to check if there's another question
    //give the next question, check the answer
}