package com.allib.vocal


import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EmotionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emotions_land)
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
                btnTag.equals("scared") -> {
                    sounds = MediaPlayer.create(this, R.raw.scared)
                    playlist.add(R.raw.angry)
                }
                else -> {
                    sounds = MediaPlayer.create(this, R.raw.angry)
                    playlist.add(R.raw.angry)
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

    fun go(view: View) {
        if(playlist.size>0) {
            val testPlaylist = MediaPlayer.create(this, playlist[position])

            testPlaylist.start()

            testPlaylist?.setOnCompletionListener {
                next(view)
            }
        }
    }

    fun next(view: View)    {
        position++

        if(playlist.size>position)
            go(view)
        else
            position=0
    }

    fun delete(@Suppress("UNUSED_PARAMETER")view: View) {
        //removes the last word in words and runs makeSentence method//
        words.removeAt(words.size-1)
        makeSentence()
        playlist.removeAt(playlist.size-1)
    }
    fun clear(@Suppress("UNUSED_PARAMETER")view: View){
        //clears words//
        words.clear()
        //runs makeSentence method//
        makeSentence()
        playlist.clear()
    }
}