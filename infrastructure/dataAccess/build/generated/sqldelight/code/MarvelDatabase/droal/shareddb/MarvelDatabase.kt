package droal.shareddb

import com.squareup.sqldelight.Transacter
import com.squareup.sqldelight.db.SqlDriver
import droal.shareddb.dataAccess.newInstance
import droal.shareddb.dataAccess.schema

interface MarvelDatabase : Transacter {
  val marvelDatabaseQueries: MarvelDatabaseQueries

  companion object {
    val Schema: SqlDriver.Schema
      get() = MarvelDatabase::class.schema

    operator fun invoke(driver: SqlDriver): MarvelDatabase =
        MarvelDatabase::class.newInstance(driver)}
}
