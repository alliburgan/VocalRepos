package com.allib.vocal

import android.media.MediaPlayer
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
    //final MediaPlayer mp = MediaPlayer.create(this, R.raw.pizza)

    fun btnClick(view: View) {
        //which button it is//
        val btnID = view.id
        //saves text of button if clicked in that variable//
        val clickedText = findViewById<Button>(btnID)
//adds the clicked text to the array list//
        words.add(clickedText.text.toString())
        //runs method//
        makeSentence()

        val sounds = MediaPlayer.create(this, R.raw.pizza)

        sounds.start()


    }

    private fun makeSentence() {
        //sets to empty string//
        sentence = ""
        //adds each word in array list to the sentence//
        for (i in words.indices) {
            sentence += words[i] + " "
        }
        findViewById<TextView>(R.id.txtSentence).apply {
            text = sentence
        }
    }
    fun clear(view: View){
        //clears words//
        words.clear()
        //runs makeSentence method//
        makeSentence()
    }

    fun delete(view: View) {
        //removes the last word in words and runs makeSentence method//
        words.removeAt(words.size-1)
        makeSentence()
    }
}