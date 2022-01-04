package com.allib.vocal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openKeyboard(view: View) {
        // Do something in response to button
        //val btnID = view.id
        val btnTag: String = view.tag.toString()

        val intent = Intent(this, FoodActivity::class.java)
        //val intent = Intent(this, Class.forName(btnTag).javaClass)

        startActivity(intent)

    }
}