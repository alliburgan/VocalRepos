package com.allib.vocal

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class VerbsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verbs)
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

/*
        val sounds = when {
            btnTag.equals("is") -> {
                MediaPlayer.create(this, R.raw.is).setVolume(100.0f,100.0f)
                MediaPlayer.create(this, R.raw.is)
            }
            btnTag.equals("do") -> {
                MediaPlayer.create(this, R.raw.do).setVolume(1.5f,1.5f)
                MediaPlayer.create(this, R.raw.do)
            }
            btnTag.equals("need") -> {
                MediaPlayer.create(this, R.raw.need).setVolume(1.0f,1.0f)
                MediaPlayer.create(this, R.raw.need)
            }
            btnTag.equals("have") -> {
                MediaPlayer.create(this, R.raw.have).setVolume(1.0f,1.0f)
                MediaPlayer.create(this, R.raw.have)
            }
            btnTag.equals("want") -> {
                MediaPlayer.create(this, R.raw.want).setVolume(1.0f,1.0f)
                MediaPlayer.create(this, R.raw.want)
                }
            btnTag.equals("come") -> {
                MediaPlayer.create(this, R.raw.come).setVolume(1.0f,1.0f)
                MediaPlayer.create(this, R.raw.come)
            }
            else -> {
                MediaPlayer.create(this, R.raw.get).setVolume(1.0f,1.0f)
                MediaPlayer.create(this, R.raw.get)
            }
        }
        sounds.start()

 */
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