package com.commit451.viewtiful.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.commit451.viewtiful.kotlin.onGlobalLayout
import com.commit451.viewtiful.kotlin.onViewPreDraw
import com.commit451.viewtiful.kotlin.setPaddingTop
import com.commit451.viewtiful.kotlin.topMargin

class MainKotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        val view = findViewById(R.id.text) as TextView

        view.onViewPreDraw(Runnable {
            Log.d("Hello", "The view is about to draw.")
            Toast.makeText(this@MainKotlinActivity, "The view is about to draw!!! How exciting", Toast.LENGTH_SHORT).show()
        })
        view.onGlobalLayout(Runnable {
            Log.d("Hello", "The view has been laid out. Also exciting!")
        })
        view.setPaddingTop(10)
        view.topMargin(10)
    }
}
