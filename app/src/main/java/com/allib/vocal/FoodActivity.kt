package com.allib.vocal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
var words = arrayListOf<String>()
var sentence = ""
class FoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)
    }

    fun btnClick(view: View) {
        val btnID = view.id
        val clickedText = findViewById<Button>(btnID)

        words.add(clickedText.text.toString())
        makeSentence()
    }

    private fun makeSentence() {
        sentence = ""
        for (i in words.indices) {
            sentence += words[i] + " "
        }
        findViewById<TextView>(R.id.txtSentence).apply {
            text = sentence
        }
    }
    fun clear(view: View){
        words.clear()
        makeSentence()
    }

    fun delete(view: View) {
        words.removeAt(words.size-1)
        makeSentence()
    }
}