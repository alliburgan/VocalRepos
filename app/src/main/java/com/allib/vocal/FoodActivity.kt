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
        setContentView(R.layout.activity_food_land)
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


        val sounds: MediaPlayer?

        when {
            btnTag.equals("pizza") -> {
               MediaPlayer.create(this, R.raw.pizza).setVolume(100.0f,100.0f)
                sounds = MediaPlayer.create(this, R.raw.pizza)
                playlist.add(R.raw.pizza)
            }
            btnTag.equals("chips") -> {
                MediaPlayer.create(this, R.raw.chips).setVolume(1.5f,1.5f)
                sounds = MediaPlayer.create(this, R.raw.chips)
                playlist.add(R.raw.chips)

            }
            btnTag.equals("pasta") -> {
                MediaPlayer.create(this, R.raw.pasta).setVolume(1.0f,1.0f)
                sounds = MediaPlayer.create(this, R.raw.pasta)
                playlist.add(R.raw.pasta)

            }
            btnTag.equals("milk") -> {
                MediaPlayer.create(this, R.raw.milk).setVolume(1.0f,1.0f)
                sounds = MediaPlayer.create(this, R.raw.milk)
                playlist.add(R.raw.milk)

            }
            else -> {
                sounds = MediaPlayer.create(this, R.raw.doctor)
                playlist.add(R.raw.doctor)

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

