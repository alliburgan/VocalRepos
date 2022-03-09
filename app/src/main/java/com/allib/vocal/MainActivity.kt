package com.allib.vocal

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

val playlist = ArrayList<Int>()
var position = 0


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_land)

        makeSentence()
    }


    fun openFoodKeyboard(@Suppress("UNUSED_PARAMETER")view: View) {
        val intent = Intent(this, FoodActivity::class.java)
        startActivity(intent)
    }

    fun openEmotionsKeyboard(@Suppress("UNUSED_PARAMETER")view: View) {
        val intent = Intent(this, EmotionsActivity::class.java)
        startActivity(intent)
    }

    fun openPeopleKeyboard(@Suppress("UNUSED_PARAMETER")view: View) {
        val intent = Intent(this, PeopleActivity::class.java)
        startActivity(intent)
    }

    fun openVerbsKeyboard(@Suppress("UNUSED_PARAMETER")view: View) {
        val intent = Intent(this, VerbsActivity::class.java)
        startActivity(intent)
    }

    fun openQuestionsKeyboard(@Suppress("UNUSED_PARAMETER")view: View) {
        val intent = Intent(this, QuestionsActivity::class.java)
        startActivity(intent)
    }

    fun upgradeYourAccount(@Suppress("UNUSED_PARAMETER")view: View) {
        val intent = Intent(this, UpgradeActivity::class.java)
        startActivity(intent)
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
        playlist.clear()
    }
    fun delete(@Suppress("UNUSED_PARAMETER")view: View) {
        //removes the last word in words and runs makeSentence method//
        words.removeAt(words.size-1)
        makeSentence()
    }
}




//hehe im here now