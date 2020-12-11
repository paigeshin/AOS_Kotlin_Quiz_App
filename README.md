# Properties - Explanation

- ScrollView
    - fillViewport: true

    ⇒ "if you set this value to true, it automatically adjust to even smaller screens"

# Setting Up Project

### Manifest

- Allow only portrait, and apply custom theme

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.quizapp">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.QuizApp">
        
        <!-- Allow only portrait -->
        <!-- Apply custom style -->
        <!-- resize UI when keyboards come up. -->
        <activity android:name=".MainActivity"
            android:screenOrientation="portrait"
            android:theme="@style/NoActionBarTheme"
            android:windowSoftInputMode="adjustResize">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        
    </application>

</manifest>
```

- styles.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <style name="NoActionBarTheme" parent="Theme.AppCompat.NoActionBar">
    </style>
</resources>
```

 

### Add material theme, build.gradle

```kotlin
plugins {
    id 'com.android.application'
    id 'kotlin-android'
    id 'kotlin-android-extensions'
}

android {
    compileSdkVersion 30
    buildToolsVersion "30.0.2"

    defaultConfig {
        applicationId "com.example.quizapp"
        minSdkVersion 16
        targetSdkVersion 30
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = '1.8'
    }
}

dependencies {
    implementation "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
    implementation 'androidx.core:core-ktx:1.3.2'
    implementation 'androidx.appcompat:appcompat:1.2.0'
    implementation 'com.google.android.material:material:1.2.1'
    implementation 'androidx.constraintlayout:constraintlayout:2.0.4'

    //implement material design
    implementation 'com.google.android.material:material:1.0.0'

    testImplementation 'junit:junit:4.+'
    androidTestImplementation 'androidx.test.ext:junit:1.1.2'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.3.0'
}
```

# Building layout

### using material design component

```xml
<com.google.android.material.textfield.TextInputLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginTop="20dp"
    style="@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox">

    <androidx.appcompat.widget.AppCompatEditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textColor="#363A43"
        android:textColorHint="#7A8089"
        android:hint="Name"/>
</com.google.android.material.textfield.TextInputLayout>
```

# Create data class

```kotlin
package com.example.quizapp

data class Question (
    val id: Int,
    val question: String,
    val image: Int,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctAnswer: Int 
)
```

# Create Object (Constants)

```kotlin
package com.example.quizapp

// TODO (STEP 5: Create a Constants Object.)
// START
object Constants {

    // TODO (STEP 6: Create a list of questions using the Question data model class. And add all the flag images to the drawable folder to add it in the list.)
    // START
    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        // 1
        val que1 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina", "Australia",
            "Armenia", "Austria", 1
        )

        questionsList.add(que1)

        // 2
        val que2 = Question(
            2, "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Angola", "Austria",
            "Australia", "Armenia", 3
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
            3, "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Belarus", "Belize",
            "Brunei", "Brazil", 4
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            4, "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Bahamas", "Belgium",
            "Barbados", "Belize", 2
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            5, "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Gabon", "France",
            "Fiji", "Finland", 3
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
            6, "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany", "Georgia",
            "Greece", "none of these", 1
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
            7, "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Dominica", "Egypt",
            "Denmark", "Ethiopia", 3
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
            8, "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Ireland", "Iran",
            "Hungary", "India", 4
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
            9, "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia", "New Zealand",
            "Tuvalu", "United States of America", 2
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
            10, "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait", "Jordan",
            "Sudan", "Palestine", 1
        )

        questionsList.add(que10)

        return questionsList
    }
    // END
}
// END
```

# Layout

### ProgressBar

```xml
<ProgressBar
                android:id="@+id/progressBar"
                style="?android:attr/progressBarStyleHorizontal"
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:max="10"
                android:minHeight="50dp"
                android:progress="0"
                android:indeterminate="false"/>
```

### XML in drawable

- correct_option_border_bg

```xml
<?xml version="1.0" encoding="utf-8"?>
<!--TODO (STEP 2: A custom border background for the default options view.)-->
<!--START-->
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">

    <solid android:color="@android:color/holo_green_light" />

    <corners android:radius="5dp" />
</shape>
<!--END-->
```

- wrong_option_border_bg

```xml
<?xml version="1.0" encoding="utf-8"?>
<!--TODO (STEP 2: A custom border background for the default options view.)-->
<!--START-->
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">

    <solid android:color="@android:color/holo_red_light" />

    <corners android:radius="5dp" />
</shape>
<!--END-->
```

- default_option_border_bg

```xml
<?xml version="1.0" encoding="utf-8"?>
<!--TODO (STEP 2: A custom border background for the default options view.)-->
<!--START-->
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">

    <stroke
        android:width="1dp"
        android:color="#E8E8E8" />

    <solid android:color="@android:color/white" />

    <corners android:radius="5dp" />
</shape>
<!--END-->
```

# Basic Logic for QuizQuestion

```kotlin
package com.example.quizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 0
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

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
                            Toast.makeText(this, "You have s uccesfully c ompleted the Quiz", Toast.LENGTH_LONG).show()
                        }
                    }

                } else {

                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if(question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
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
```