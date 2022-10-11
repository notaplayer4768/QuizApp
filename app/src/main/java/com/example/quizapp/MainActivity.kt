package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    companion object{
        val TAG = "MainActivity"
    }
    private lateinit var debuggingQuiz : Quiz
    private lateinit var questions : List<Question>
    private lateinit var questionText : TextView
    private lateinit var scoreText : TextView
    private lateinit var button1 : Button
    private lateinit var button2 : Button
    private lateinit var button3 : Button
    private lateinit var button4 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadQuestions()
        debuggingQuiz = Quiz(questions)
        wireWidgets()
        setWidgets()
        scoreText.text = "Score: 0"
        button1.setOnClickListener {
            checkAnswer(button1.text)
        }
        button2.setOnClickListener {
            checkAnswer(button2.text)
        }
        button3.setOnClickListener {
            checkAnswer(button3.text)
        }
        button4.setOnClickListener {
            checkAnswer(button4.text)
        }
    }

    private fun checkAnswer(text: CharSequence) {
        var temp = debuggingQuiz.isCorrect(text)
        setWidgets()
    }


    private fun setWidgets() {
        questionText.text = debuggingQuiz.initializeQuestionText()
        val myList = debuggingQuiz.initializeOptions()
        button1.text = myList.get(0)
        button2.text = myList.get(1)
        button3.text = myList.get(2)
        button4.text = myList.get(3)
        scoreText.text = debuggingQuiz.score.toString()
        //^^ fix this line of code
        debuggingQuiz.addToCurrentQuestionNum()
    }


    private fun wireWidgets() {
        questionText = findViewById(R.id.main_questionText)
        scoreText = findViewById(R.id.main_scoreText)
        button1 = findViewById(R.id.main_option1)
        button2 = findViewById(R.id.main_option2)
        button3 = findViewById(R.id.main_option3)
        button4 = findViewById(R.id.main_option4)
    }

    private fun loadQuestions() {
        // reading the json from the raw folder

        // step 1: open the raw resource as an InputStream
        // R.raw.questions --> R is the Resources class, raw is folder,
        // questions is the file
        val inputStream = resources.openRawResource(R.raw.questions)
        // step 2: use a buffered reader on the inputstream to read the
        // the text into a string. we call it jsonString because it's the entire JSON file in a string
        val jsonString = inputStream.bufferedReader().use {
            // the last line of the use function is returned
            it.readText()
        }
        Log.d(TAG, "onCreate: $jsonString")
        // use gson to convert the jsonText into a List<Question>
        // log the list of questions and see if your Question objects all appear correct
        val gson = Gson()
        // gson needs to know what kind of list you are converting to
        // typetoken tells gson it will be a List<Question>
        val type = object : TypeToken<List<Question>>() { }.type
        questions = gson.fromJson<List<Question>>(jsonString, type)
        Log.d(TAG, "onCreate: $questions")
    }
    //change
}