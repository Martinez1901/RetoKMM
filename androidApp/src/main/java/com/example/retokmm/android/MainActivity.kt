package com.example.retokmm.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.retokmm.viewModel.ViewModelTest


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : ViewModelTest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(ViewModelTest::class.java)
        viewModel.getInformation()
        observer()
        val tv: TextView = findViewById(R.id.text_view)
        tv.text = "greet"
    }

    private fun observer() {

    }
}
