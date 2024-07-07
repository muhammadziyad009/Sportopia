package com.example.sportopia1.adapters

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

class SharedPreManager(context : Context) {





    private val isFirst = context.getSharedPreferences(
        "IsFirst", AppCompatActivity.MODE_PRIVATE
    )

    private val editor = isFirst.edit()

    private val keyIsFirstTime = "isFirstTime"

    var isFirstTime
        get() = isFirst.getBoolean(keyIsFirstTime, true)
        set(value) {
            editor.putBoolean(keyIsFirstTime, value)
            editor.commit()
        }
}