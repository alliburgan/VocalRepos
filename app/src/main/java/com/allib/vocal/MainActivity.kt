package com.allib.vocal

import android.content.Intent
import android.media.MediaPlayer
import android.media.MediaPlayer.OnCompletionListener
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private var mediaPlayer: MediaPlayer? = null
val playlist = ArrayList<Int>()
var position = 0


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        makeSentence()
    }


    fun openFoodKeyboard(view: View) {
        val intent = Intent(this, FoodActivity::class.java)
        startActivity(intent)
    }

    fun openEmotionsKeyboard(view: View) {
        val intent = Intent(this, EmotionsActivity::class.java)
        startActivity(intent)
    }

    fun openPeopleKeyboard(view: View) {
        val intent = Intent(this, PeopleActivity::class.java)
        startActivity(intent)
    }

    fun openVerbsKeyboard(view: View) {
        val intent = Intent(this, VerbsActivity::class.java)
        startActivity(intent)
    }

    fun openQuestionsKeyboard(view: View) {
        val intent = Intent(this, QuestionsActivity::class.java)
        startActivity(intent)
    }

    fun go(view: View) {


        var testPlaylist = MediaPlayer.create(this, playlist[position])
        testPlaylist.start()
        //testPlaylist = MediaPlayer.create(this,playlist[1])
        //testPlaylist.start()

            testPlaylist?.setOnCompletionListener(OnCompletionListener
            {
                next(position, view)
            })

    }

    fun next(num: Int, view: View)    {
        position++

        if(playlist.size>position)
            go(view)
        else
            position = 0

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
}




//hehe im here now