package com.example.retokmm.viewModel

import com.example.domain.model.CharacterDomain
import com.example.domain.useCase.GetAllCharactersUseCase
import com.example.retokmm.di.KodeinInjector
import com.example.retokmm.fromListDomainToListView
import com.example.retokmm.model.CharacterView
import com.example.utilities.Response
import dev.icerock.moko.mvvm.livedata.LiveData
import dev.icerock.moko.mvvm.livedata.MutableLiveData
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.kodein.di.instance
import kotlin.random.Random

class CharactersListViewModel : ViewModel() {

    private var _characters =
        MutableLiveData<Resource<List<CharacterView>>>(Resource.loading(null, null))
    val characters: LiveData<Resource<List<CharacterView>>> get() = _characters

    private val getAllCharactersUseCase by KodeinInjector.instance<GetAllCharactersUseCase>()

    fun getInformation() {
        viewModelScope.launch {
            Resource.loading(null, null)
            val response = getAllCharactersUseCase.getAllCharacters(true)
            delay(2000)
            processCharactersListResponse(response)
            delay(2000)
            processCharactersListResponse(response)
            delay(2000)
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