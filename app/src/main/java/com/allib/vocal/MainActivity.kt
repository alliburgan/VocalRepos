package com.allib.vocal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendMessage(view: View) {
        // Do something in response to button
        val clickedText = findViewById<Button>(R.id.btnPizza)
        val sentence = clickedText.text.toString()
        findViewById<TextView>(R.id.txtSentence).apply{
            text = sentence
        }
    }
}