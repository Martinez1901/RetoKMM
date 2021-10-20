package com.example.retokmm.viewModel

import com.example.domain.model.ComicDomain
import com.example.domain.useCase.GetAllComicsUseCase
import com.example.domain.useCase.SearchComicsUseCase
import com.example.retokmm.di.KodeinInjector
import com.example.retokmm.model.ComicShared
import com.example.retokmm.util.Resource
import com.example.retokmm.util.fromListDomainComicToListView
import com.example.utilities.Response
import dev.icerock.moko.mvvm.UI
import dev.icerock.moko.mvvm.livedata.LiveData
import dev.icerock.moko.mvvm.livedata.MutableLiveData
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.*
import org.kodein.di.instance

class ComicsViewModel : ViewModel() {

    private var _comics =
        MutableLiveData<Resource<List<ComicShared>>>(Resource.loading(null, null))
    val comics: LiveData<Resource<List<ComicShared>>> get() = _comics

    private val getAllComicsUseCase by KodeinInjector.instance<GetAllComicsUseCase>()
    private val searchComicsUseCase by KodeinInjector.instance<SearchComicsUseCase>()

    fun getInformation(updateData: Boolean) {
        viewModelScope.launch {
            Resource.loading(null, null)
            val response = getAllComicsUseCase.getAllComics(updateData)
            processComicsListResponse(response)
        }
    }

    fun searchComics(comicTitle: String) {
        viewModelScope.launch {
            Resource.loading(null, null)
            val response = searchComicsUseCase.searchComic(comicTitle)
            processComicsListResponse(response)
        }
    }

    private fun processComicsListResponse(response: Response<List<ComicDomain>>) {
        if (response is Response.Success) {
            _comics.postValue(
                Resource.success(
                    response.data.fromListDomainComicToListView()
                )
            )
        } else if (response is Response.Error) {
            _comics.postValue(
                Resource.error(null, 0, "error")
            )
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}