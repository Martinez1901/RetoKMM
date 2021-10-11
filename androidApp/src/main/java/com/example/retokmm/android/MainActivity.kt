package com.example.retokmm.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.retokmm.model.CharacterView
import com.example.retokmm.viewModel.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private lateinit var charactersListViewModel: CharactersListViewModel
    private lateinit var charactersListObserver: (state: Resource<List<CharacterView>>) -> Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        charactersListViewModel = ViewModelProvider(this).get(CharactersListViewModel::class.java)
        charactersListViewModel.getInformation()
        listener()

    }

    private fun listener() {
        charactersListObserver =
            { getCharacterListState(charactersListViewModel.characters.value) }
        charactersListViewModel.characters.addObserver(charactersListObserver)
    }

    private fun getCharacterListState(result: Resource<List<CharacterView>>) {
        when (result.status) {
            Status.SUCCESS -> {
                //onSuccessGetGitHubList(response.data)
                result.data?.let {
                    val tv: TextView = findViewById(R.id.text_view)
                    tv.text = it[Random.nextInt(0, it.size - 1)].name
                }/* ?: run {
                    Toast.makeText(this@MainActivity,"Vacio",Toast.LENGTH_LONG).show()
                }*/
            }

            Status.LOADING -> {
            }

            Status.ERROR -> {

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        charactersListViewModel.characters.removeObserver { charactersListObserver }
    }

}
