package com.allib.vocal

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

var words = arrayListOf<String>()
var sentence = ""



class FoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)
    makeSentence()

    }

    fun btnClick(view: View) {
        // find which button it is
        val btnTag = view.tag
        // add the corresponding word to the arraylist words
        words.add(btnTag.toString())
        // run the makeSentence method
        makeSentence()

        // first attempt at using audio files
        //var sounds = MediaPlayer.create(this, R.raw.friend)

        // volume glitch?
        //volumeControlStream = AudioManager.STREAM_MUSIC


        val sounds = when {
            btnTag.equals("pizza") -> {
               MediaPlayer.create(this, R.raw.pizza).setVolume(100.0f,100.0f)
                MediaPlayer.create(this, R.raw.pizza)
            }
            btnTag.equals("chips") -> {
                MediaPlayer.create(this, R.raw.chips).setVolume(1.5f,1.5f)
                MediaPlayer.create(this, R.raw.chips)
            }
            btnTag.equals("pasta") -> {
                MediaPlayer.create(this, R.raw.pasta).setVolume(1.0f,1.0f)
                MediaPlayer.create(this, R.raw.pasta)
            }
            btnTag.equals("milk") -> {
                MediaPlayer.create(this, R.raw.milk).setVolume(1.0f,1.0f)
                MediaPlayer.create(this, R.raw.milk)
            }
            else -> {
                MediaPlayer.create(this, R.raw.angry).setVolume(1.0f,1.0f)
                MediaPlayer.create(this, R.raw.angry)
            }
        }
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