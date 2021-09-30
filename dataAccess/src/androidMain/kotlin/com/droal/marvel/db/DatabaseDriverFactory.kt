package com.droal.marvel.db

import com.droal.marvel.di.ContextArg
import com.example.dataaccess.db.Database
import com.squareup.sqldelight.db.SqlDriver

expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}

expect fun getSqlDriver(contextArg: ContextArg? = null): SqlDriver

object DatabaseCreator {
    fun getDataBase(contextArgs: ContextArg?): Database? {
        val sqlDriver  = getSqlDriver(contextArgs)
        val database : Database?
        sqlDriver.let {
            database = Database(it)
        }
        return database
    }
}