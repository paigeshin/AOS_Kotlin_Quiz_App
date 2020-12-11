package com.example.quizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 0
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mQuestionList = Constants.getQuestions()
        setQuestion()

        tvOptionOne.setOnClickListener(this)
        tvOptionTwo.setOnClickListener(this)
        tvOptionThree.setOnClickListener(this)
        tvOptionFour.setOnClickListener(this)


    }

    private fun setQuestion() {
        mCurrentPosition = 1

        val question: Question = mQuestionList!!.get(mCurrentPosition - 1)

        defaultOptionView()

        progressBar.progress = mCurrentPosition
        tvCounter.text = "$mCurrentPosition/${progressBar.max}"

        tvQuestion.text = question.question
        ivImage.setImageResource(question.image)
        tvOptionOne.text = question.optionOne
        tvOptionTwo.text = question.optionTwo
        tvOptionThree.text = question.optionThree
        tvOptionFour.text = question.optionFour
    }

    // set default UI for buttons
    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        options.add(0, tvOptionOne)
        options.add(1, tvOptionTwo)
        options.add(2, tvOptionThree)
        options.add(3, tvOptionFour)
        for(option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    // handle multiple button events
    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.tvOptionOne -> {
                selectedOptionView(tvOptionOne, 0)
            }
            R.id.tvOptionTwo -> {
                selectedOptionView(tvOptionTwo, 1)
            }
            R.id.tvOptionThree -> {
                selectedOptionView(tvOptionThree, 2)
            }
            R.id.tvOptionFour -> {
                selectedOptionView(tvOptionFour, 3)
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNumber: Int) {
        defaultOptionView() //reset button designs
        mSelectedOptionPosition = selectedOptionNumber
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
    }


}