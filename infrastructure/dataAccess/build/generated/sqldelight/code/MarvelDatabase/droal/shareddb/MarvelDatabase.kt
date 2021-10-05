package droal.shareddb

import com.squareup.sqldelight.Transacter
import com.squareup.sqldelight.db.SqlDriver
import droal.shareddb.dataAccess.newInstance
import droal.shareddb.dataAccess.schema

public interface MarvelDatabase : Transacter {
  public val marvelDatabaseQueries: MarvelDatabaseQueries

  public companion object {
    public val Schema: SqlDriver.Schema
      get() = MarvelDatabase::class.schema

    public operator fun invoke(driver: SqlDriver): MarvelDatabase =
        MarvelDatabase::class.newInstance(driver)
  }
}
