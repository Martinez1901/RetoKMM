package com.example.retokmm.viewModel

import com.example.domain.model.Character
import com.example.domain.useCase.GetAllCharactersUseCase
import com.example.retokmm.di.KodeinInjector
import com.example.utilities.Response
import dev.icerock.moko.mvvm.livedata.MutableLiveData
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import org.kodein.di.instance

class CharactersListViewModel : ViewModel() {

    var getCharactersLiveData =
        MutableLiveData<CharactersListState>(LoadingGetCharacterListState())

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
            getCharactersLiveData.postValue(
                SuccessGetCharacterListState(
                    response
                )
            )
        } else if (response is Response.Error) {
            getCharactersLiveData.postValue(
                ErrorGetCharacterListState(
                    response
                )
            )
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

}