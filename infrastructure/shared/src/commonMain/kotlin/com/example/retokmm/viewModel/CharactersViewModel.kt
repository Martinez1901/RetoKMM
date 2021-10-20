package com.example.retokmm.viewModel

import com.example.domain.model.CharacterDomain
import com.example.domain.useCase.GetAllCharactersUseCase
import com.example.domain.useCase.SearchCharacterUseCase
import com.example.retokmm.di.KodeinInjector
import com.example.retokmm.util.fromListDomainToListView
import com.example.retokmm.model.CharacterShared
import com.example.retokmm.util.Resource
import com.example.utilities.Response
import dev.icerock.moko.mvvm.UI
import dev.icerock.moko.mvvm.livedata.LiveData
import dev.icerock.moko.mvvm.livedata.MutableLiveData
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.kodein.di.instance

class CharactersViewModel : ViewModel() {

    private var _characters =
        MutableLiveData<Resource<List<CharacterShared>>>(Resource.loading(null, null))
    val characters: LiveData<Resource<List<CharacterShared>>> get() = _characters

    private val getAllCharactersUseCase by KodeinInjector.instance<GetAllCharactersUseCase>()
    private val searchCharacterUseCase by KodeinInjector.instance<SearchCharacterUseCase>()

    fun getInformation(updateData: Boolean) {
        viewModelScope.launch {
            Resource.loading(null, null)
            val response = getAllCharactersUseCase.getAllCharacters(updateData)
            processCharactersListResponse(response)
        }
    }

    fun searchCharacter(characterTitle: String){
        viewModelScope.launch {
            val response = searchCharacterUseCase.searchCharacter(characterTitle)
            processCharactersListResponse(response)
        }

    }

    private fun processCharactersListResponse(response: Response<List<CharacterDomain>>) {
        if (response is Response.Success) {
            _characters.postValue(
                Resource.success(
                    response.data.fromListDomainToListView()
                )
            )
        } else if (response is Response.Error) {
            _characters.postValue(
                Resource.error(null, 0, "error")
            )
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

}