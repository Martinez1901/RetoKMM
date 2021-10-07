package com.example.retokmm.di

import com.droal.marvel.di.ContextArg
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object InjectorCommon {

    var context: ContextArg? = null

    fun provideContextArgs(contextArg: ContextArg): ContextArg? {
        context = contextArg
        return context
    }
}