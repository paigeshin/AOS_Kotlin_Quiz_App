package com.example.quizapp.activities

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quizapp.Constants
import com.example.quizapp.Question
import com.example.quizapp.R
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 0
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mCurrentPosition =  1

        mQuestionList = Constants.getQuestions()
        setQuestion()

        tvOptionOne.setOnClickListener(this)
        tvOptionTwo.setOnClickListener(this)
        tvOptionThree.setOnClickListener(this)
        tvOptionFour.setOnClickListener(this)
        btn_submit.setOnClickListener(this)

    }

    private fun setQuestion() {

        val question: Question = mQuestionList!!.get(mCurrentPosition - 1)

        defaultOptionView()

        if(mCurrentPosition == mQuestionList!!.size) {
            btn_submit.text = "FINISH"
        } else  {
            btn_submit.text = "SUBMIT"
        }

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
            R.id.btn_submit -> {
                //User not selected  option
                if(mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        } else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }

                } else {

                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if(question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    } else {
                        mCorrectAnswers++
                    }
                    answerView(mSelectedOptionPosition, R.drawable.correct_option_border_bg)
                    if(mCurrentPosition == mQuestionList!!.size) {
                        btn_submit.text = "FINISH"
                    } else {
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0

                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when(answer) {
            1 -> {
                tvOptionOne.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                tvOptionTwo.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                tvOptionThree.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                tvOptionFour.background = ContextCompat.getDrawable(this, drawableView)
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