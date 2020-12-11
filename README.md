# AOS_Kotlin_Quiz_App

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