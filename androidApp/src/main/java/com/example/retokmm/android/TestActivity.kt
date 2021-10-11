package com.example.retokmm.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.retokmm.viewModel.*
import com.example.utilities.Response

class TestActivity : AppCompatActivity() {

    private lateinit var charactersListViewModel : CharactersListViewModel
    private lateinit var charactersListObserver: (state: CharactersListState) -> Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        charactersListViewModel = ViewModelProvider(this).get(CharactersListViewModel::class.java)
        charactersListViewModel.getInformation()

        listener()
    }

    private fun listener() {
        charactersListObserver = {getCharacterListState(charactersListViewModel.getCharactersLiveData.value)}
        charactersListViewModel.getCharactersLiveData.addObserver(charactersListObserver)
    }

    fun getCharacterListState(state: CharactersListState) {
        when (state) {
            is SuccessGetCharacterListState -> {
                val response =  state.response as Response.Success
                //onSuccessGetGitHubList(response.data)
                val data = response.data
                val tv: TextView = findViewById(R.id.text_view)
                tv.text = data[0].name
            }

            is LoadingGetCharacterListState -> {
            }

            is ErrorGetCharacterListState -> {
                val response =  state.response as Response.Error
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        charactersListViewModel.getCharactersLiveData.removeObserver {charactersListObserver }
    }
}