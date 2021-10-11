package com.example.retokmm.di

import com.droal.marvel.db.DatabaseCreator
import com.droal.marvel.db.DatabaseSourceImpl
import com.droal.marvel.db.IDatabaseSource
import com.droal.marvel.network.ServiceFactory
import com.droal.marvel.network.api.CharacterAPIImpl
import com.droal.marvel.network.api.ICharacterAPI
import com.droal.marvel.network.service.CharacterEndPoints
import com.droal.marvel.repository.CharacterRepositoryImpl
import com.example.domain.repository.ICharacterRepository
import com.example.domain.useCase.GetAllCharactersUseCase
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
    bind<IDatabaseSource>() with provider { DatabaseSourceImpl(
        DatabaseCreator.getDataBase(
        InjectorCommon.context)) }
    /**
     * API
     */
    bind<ServiceFactory>() with provider { ServiceFactory() }
    bind<CharacterEndPoints>() with provider { CharacterEndPoints(instance()) }
    bind<ICharacterAPI>() with provider { CharacterAPIImpl(instance()) }
    /**
     * REPOSITORIES
     */

    /**
     * REPOSITORIES
     */
    bind<ICharacterRepository>() with provider { CharacterRepositoryImpl(DatabaseSourceImpl(
        DatabaseCreator.getDataBase(
            InjectorCommon.context)),instance()) }



    /**
     * USECASES
     */

    /**
     * USECASES
     */

    /**
     * USECASES
     */
    bind<GetAllCharactersUseCase>() with singleton { GetAllCharactersUseCase(instance()) }
}