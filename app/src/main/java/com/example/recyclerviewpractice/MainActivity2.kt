package com.example.recyclerviewpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerviewpractice.databinding.ActivityMain2Binding
import com.example.recyclerviewpractice.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainbinding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(mainbinding.root)

        var intent = getIntent()
        mainbinding.textView.text = intent.getStringExtra("NUM")
        mainbinding.dateText.text = intent.getStringExtra("DATE")

    }
}