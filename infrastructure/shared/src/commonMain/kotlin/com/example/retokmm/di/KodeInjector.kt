package com.example.retokmm.di

import com.droal.marvel.db.DatabaseCreator
import com.droal.marvel.db.DatabaseSourceImpl
import com.droal.marvel.db.IDatabaseSource
import com.droal.marvel.network.ServiceFactory
import com.droal.marvel.network.api.CharacterAPIImpl
import com.droal.marvel.network.api.ComicsAPIImpl
import com.droal.marvel.network.api.ICharacterAPI
import com.droal.marvel.network.api.IComicsAPI
import com.droal.marvel.network.service.CharacterEndPoints
import com.droal.marvel.network.service.ComicsEndPoints
import com.droal.marvel.repository.CharacterRepositoryImpl
import com.droal.marvel.repository.ComicsRepositoryImpl
import com.example.domain.repository.ICharacterRepository
import com.example.domain.repository.IComicsRepository
import com.example.domain.useCase.GetAllCharactersUseCase
import com.example.domain.useCase.GetAllComicsUseCase
import com.example.domain.useCase.SearchCharacterUseCase
import com.example.domain.useCase.SearchComicsUseCase
import kotlinx.coroutines.Dispatchers
import org.kodein.di.*
import kotlin.coroutines.CoroutineContext
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
val KodeinInjector = DI{

    bind<CoroutineContext>() with provider { Dispatchers.Main }
    /**
     * DATABASE
     */
    bind<IDatabaseSource>() with singleton { DatabaseSourceImpl(
        DatabaseCreator.getDataBase(
        InjectorCommon.context)) }
    /**
     * API
     */
    bind<ServiceFactory>() with provider { ServiceFactory() }
    bind<CharacterEndPoints>() with provider { CharacterEndPoints(instance()) }
    bind<ComicsEndPoints>() with provider { ComicsEndPoints(instance()) }
    bind<ICharacterAPI>() with provider { CharacterAPIImpl(instance()) }
    bind<IComicsAPI>() with provider { ComicsAPIImpl(instance()) }
    /**
     * REPOSITORIES
     */

    /**
     * REPOSITORIES
     */
    bind<ICharacterRepository>() with provider { CharacterRepositoryImpl(DatabaseSourceImpl(
        DatabaseCreator.getDataBase(
            InjectorCommon.context)),instance()) }

    bind<IComicsRepository>() with provider { ComicsRepositoryImpl(DatabaseSourceImpl(
        DatabaseCreator.getDataBase(
            InjectorCommon.context)),instance()) }


    /**
     * USECASES
     */

    /**
     * USECASES
     */
    bind<GetAllCharactersUseCase>() with provider { GetAllCharactersUseCase(instance()) }
    bind<SearchCharacterUseCase>() with provider { SearchCharacterUseCase(instance()) }
    /**
     * USECASES COMICS
     */
    bind<GetAllComicsUseCase>() with provider { GetAllComicsUseCase(instance()) }
    bind<SearchComicsUseCase>() with provider { SearchComicsUseCase(instance()) }
}