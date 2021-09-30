package com.example.retokmm.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retokmm.Greeting
import android.widget.TextView
import com.example.retokmm.android.databinding.ActivityMainBinding

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


    }
}
