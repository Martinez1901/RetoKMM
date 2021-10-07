package com.example.retokmm.viewModel

import com.example.domain.model.Character
import com.example.domain.useCase.GetAllCharactersUseCase
import com.example.retokmm.di.KodeinInjector
import com.example.utilities.Response
import dev.icerock.moko.mvvm.livedata.MutableLiveData
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.launch
import org.kodein.di.instance

class ViewModelTest : ViewModel() {

    var useCase = MutableLiveData("")

    private val getAllCharactersUseCase by KodeinInjector.instance<GetAllCharactersUseCase>()

    fun getData(): String {
        getInformation()
        return "data"
    }

    fun getInformation() {
        viewModelScope.launch {
            val response = getAllCharactersUseCase.getAllCharacters(true)
            processCharactersListResponse(response)
        }
    }

    private fun processCharactersListResponse(response: Response<List<Character>>) {
        if (response is Response.Success) {
            print(response.data)
        } else if (response is Response.Error) {
            print(response.error)
        }
    }

}