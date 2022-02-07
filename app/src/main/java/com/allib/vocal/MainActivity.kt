package com.allib.vocal

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
            var playlist = ArrayList<Int>()

            playlist.add(R.raw.excited)
            playlist.add(R.raw.scared)
            playlist.add(R.raw.sad)


            for (i in playlist.indices) {
                var testPlaylist = MediaPlayer.create(this, playlist[i])
                testPlaylist.start()
            }
        }
    }

//hehe im here now