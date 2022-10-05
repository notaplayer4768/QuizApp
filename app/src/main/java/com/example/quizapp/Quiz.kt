package com.example.quizapp

/*data?*/ class Quiz (val questions: List <Question>){
    private var score = 0
    private var currentQuestionNum = 1
    public fun initializeQuestionText(): String {
        return questions[currentQuestionNum].currentQuestion
    }
    //variables to track score, current question
    //function to check if there's another question
    //give the next question, check the answer
}