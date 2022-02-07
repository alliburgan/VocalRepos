package com.allib.vocal

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class PeopleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people)
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
            btnTag.equals("mom") -> {
                MediaPlayer.create(this, R.raw.mom).setVolume(100.0f,100.0f)
                MediaPlayer.create(this, R.raw.mom)
            }
            btnTag.equals("dad") -> {
                MediaPlayer.create(this, R.raw.dad).setVolume(1.5f,1.5f)
                MediaPlayer.create(this, R.raw.dad)
            }
            btnTag.equals("teacher") -> {
                MediaPlayer.create(this, R.raw.teacher).setVolume(1.0f,1.0f)
                MediaPlayer.create(this, R.raw.teacher)
            }
            btnTag.equals("doctor") -> {
                MediaPlayer.create(this, R.raw.doctor).setVolume(1.0f,1.0f)
                MediaPlayer.create(this, R.raw.doctor)

            }
            else -> {
                MediaPlayer.create(this, R.raw.friend).setVolume(1.0f,1.0f)
                MediaPlayer.create(this, R.raw.friend)
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