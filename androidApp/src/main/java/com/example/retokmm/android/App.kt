package com.example.retokmm.android

import androidx.multidex.MultiDexApplication
import com.droal.marvel.di.ContextArg
import com.example.retokmm.di.InjectorCommon

class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        InjectorCommon.provideContextArgs(ContextArg(this))
    }

}