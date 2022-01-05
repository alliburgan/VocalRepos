package com.allib.vocal

import android.content.Intent
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
}
//hehe im here now