package com.allib.vocal


import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PeopleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people_land)
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
            btnTag.equals("mom") -> {
                sounds = MediaPlayer.create(this, R.raw.mom)
                playlist.add(R.raw.mom)
            }
            btnTag.equals("dad") -> {
                sounds = MediaPlayer.create(this, R.raw.dad)
                playlist.add(R.raw.dad)
            }
            btnTag.equals("teacher") -> {
                sounds = MediaPlayer.create(this, R.raw.teacher)
                playlist.add(R.raw.teacher)
            }
            btnTag.equals("doctor") -> {
                sounds = MediaPlayer.create(this, R.raw.doctor)
                playlist.add(R.raw.doctor)
            }
            else -> {
                sounds = MediaPlayer.create(this, R.raw.angry)
                playlist.add(R.raw.excited)
            }
        }//Still needs brother and sister

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