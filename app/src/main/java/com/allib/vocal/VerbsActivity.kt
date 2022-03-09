package com.allib.vocal


import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class VerbsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verbs_land)
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
            //btnTag.equals("is") -> {
                //sounds = MediaPlayer.create(this, R.raw.is)
                //playlist.add(R.raw.is)
            //}
            /*
            btnTag.equals("do") -> {
                sounds = MediaPlayer.create(this, R.raw.do)
                playlist.add(R.raw.do)
            }
            */
            btnTag.equals("need") -> {
                sounds = MediaPlayer.create(this, R.raw.need)
                playlist.add(R.raw.need)
            }
            /*
            btnTag.equals("have") -> {
                sounds = MediaPlayer.create(this, R.raw.have)
                playlist.add(R.raw.have)
            }
            */
            btnTag.equals("want") -> {
                sounds = MediaPlayer.create(this, R.raw.want)
                playlist.add(R.raw.want)
            }
            /*
            btnTag.equals("come") -> {
                sounds = MediaPlayer.create(this, R.raw.come)
                playlist.add(R.raw.come)
            }*/
            else -> {
                sounds = MediaPlayer.create(this, R.raw.angry)
                playlist.add(R.raw.angry)
            }
        }
        sounds?.start()


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