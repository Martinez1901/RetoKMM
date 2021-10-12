package com.example.retokmm.viewModel

import com.example.domain.model.ComicDomain
import com.example.domain.useCase.GetAllComicsUseCase
import com.example.retokmm.di.KodeinInjector
import com.example.retokmm.model.ComicShared
import com.example.retokmm.util.Resource
import com.example.retokmm.util.fromListDomainComicToListView
import com.example.retokmm.util.fromListDomainToListView
import com.example.utilities.Response
import dev.icerock.moko.mvvm.livedata.LiveData
import dev.icerock.moko.mvvm.livedata.MutableLiveData
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import org.kodein.di.instance

class ComicsListViewModel : ViewModel() {

    private var _comics =
        MutableLiveData<Resource<List<ComicShared>>>(Resource.loading(null, null))
    val comics: LiveData<Resource<List<ComicShared>>> get() = _comics

    private val getAllComicsUseCase by KodeinInjector.instance<GetAllComicsUseCase>()

    fun getInformation(updateData: Boolean) {
        viewModelScope.launch {
            Resource.loading(null, null)
            val response = getAllComicsUseCase.getAllComics(updateData)
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