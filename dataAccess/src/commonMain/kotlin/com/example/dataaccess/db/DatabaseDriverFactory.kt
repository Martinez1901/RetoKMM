package com.example.dataaccess.db

import com.example.dataaccess.di.ContextArg
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