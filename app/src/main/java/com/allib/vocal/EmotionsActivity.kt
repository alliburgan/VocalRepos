package com.allib.vocal

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class EmotionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emotions)
    makeSentence()

    }

        fun btnClick(view: View) {
            // find which button it is
            val btnTag = view.tag
            // add the corresponding word to the arraylist words
            words.add(btnTag.toString())
            // run the makeSentence method
            makeSentence()

            val sounds: MediaPlayer?

            when {
            btnTag.equals("sad") -> {
                sounds = MediaPlayer.create(this, R.raw.sad)
                playlist.add(R.raw.sad)
                }
                /*
                btnTag.equals("mad") -> {
                    sounds = MediaPlayer.create(this, R.raw.mad)
                playlist.add(R.raw.)
                } */
                btnTag.equals("excited") -> {
                    sounds = MediaPlayer.create(this, R.raw.excited)
                    playlist.add(R.raw.excited)
                }
                btnTag.equals("happy") -> {
                    sounds = MediaPlayer.create(this, R.raw.happy)
                    playlist.add(R.raw.happy)
                }
                btnTag.equals("angry") -> {
                    sounds = MediaPlayer.create(this, R.raw.teacher)
                    playlist.add(R.raw.teacher)
                }
                else -> {
                    sounds = MediaPlayer.create(this, R.raw.scared)
                    playlist.add(R.raw.scared)
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

        fun clear(@Suppress("UNUSED_PARAMETER")view: View){
            //clears words//
            words.clear()
            //runs makeSentence method//
            makeSentence()
        }
        fun delete(@Suppress("UNUSED_PARAMETER")view: View) {
            //removes the last word in words and runs makeSentence method//
            words.removeAt(words.size-1)
            makeSentence()
        }
}