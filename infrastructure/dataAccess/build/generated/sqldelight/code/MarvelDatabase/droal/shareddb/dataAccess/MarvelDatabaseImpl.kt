package droal.shareddb.dataAccess

import com.squareup.sqldelight.Query
import com.squareup.sqldelight.TransacterImpl
import com.squareup.sqldelight.db.SqlCursor
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.internal.copyOnWriteList
import droal.shareddb.Character_Entity
import droal.shareddb.MarvelDatabase
import droal.shareddb.MarvelDatabaseQueries
import droal.shareddb.SelectAllCharacters
import kotlin.Any
import kotlin.Int
import kotlin.String
import kotlin.collections.MutableList
import kotlin.jvm.JvmField
import kotlin.reflect.KClass

internal val KClass<MarvelDatabase>.schema: SqlDriver.Schema
  get() = MarvelDatabaseImpl.Schema

internal fun KClass<MarvelDatabase>.newInstance(driver: SqlDriver): MarvelDatabase =
    MarvelDatabaseImpl(driver)

private class MarvelDatabaseImpl(
  driver: SqlDriver
) : TransacterImpl(driver), MarvelDatabase {
  override val marvelDatabaseQueries: MarvelDatabaseQueriesImpl = MarvelDatabaseQueriesImpl(this,
      driver)

  object Schema : SqlDriver.Schema {
    override val version: Int
      get() = 1

    override fun create(driver: SqlDriver) {
      driver.execute(null, """
          |CREATE TABLE Character_Entity (
          |    id TEXT NOT NULL PRIMARY KEY,
          |    name TEXT NOT NULL,
          |    description TEXT,
          |    modified TEXT,
          |    resourceURI TEXT,
          |    thumbnailId TEXT NOT NULL
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE Thumbnail_Entity(
          |    idThumb TEXT NOT NULL PRIMARY KEY,
          |    path TEXT NOT NULL
          |)
          """.trimMargin(), 0)
    }

    override fun migrate(
      driver: SqlDriver,
      oldVersion: Int,
      newVersion: Int
    ) {
    }
  }
}

private class MarvelDatabaseQueriesImpl(
  private val database: MarvelDatabaseImpl,
  private val driver: SqlDriver
) : TransacterImpl(driver), MarvelDatabaseQueries {
  internal val selectAllCharacters: MutableList<Query<*>> = copyOnWriteList()

  internal val selectCharacterById: MutableList<Query<*>> = copyOnWriteList()

  override fun <T : Any> selectAllCharacters(mapper: (
    id: String,
    name: String,
    description: String?,
    modified: String?,
    resourceURI: String?,
    thumbnailId: String,
    idThumb: String,
    path: String
  ) -> T): Query<T> = Query(-1984908686, selectAllCharacters, driver, "MarvelDatabase.sq",
      "selectAllCharacters", """
  |SELECT Character_Entity.*, Thumbnail_Entity.*
  |FROM Character_Entity
  |INNER JOIN Thumbnail_Entity ON Thumbnail_Entity.idThumb == Character_Entity.thumbnailId
  """.trimMargin()) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2),
      cursor.getString(3),
      cursor.getString(4),
      cursor.getString(5)!!,
      cursor.getString(6)!!,
      cursor.getString(7)!!
    )
  }

  override fun selectAllCharacters(): Query<SelectAllCharacters> =
      selectAllCharacters(::SelectAllCharacters)

  override fun <T : Any> selectCharacterById(id: String, mapper: (
    id: String,
    name: String,
    description: String?,
    modified: String?,
    resourceURI: String?,
    thumbnailId: String
  ) -> T): Query<T> = SelectCharacterByIdQuery(id) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2),
      cursor.getString(3),
      cursor.getString(4),
      cursor.getString(5)!!
    )
  }

  override fun selectCharacterById(id: String): Query<Character_Entity> = selectCharacterById(id,
      ::Character_Entity)

  override fun insertCharacter(
    id: String,
    name: String,
    description: String?,
    modified: String?,
    resourceURI: String?,
    thumbnailId: String
  ) {
    driver.execute(-1811368685, """
    |INSERT INTO Character_Entity(id, name, description, modified, resourceURI, thumbnailId)
    |VALUES(?, ?, ?, ?, ?, ?)
    """.trimMargin(), 6) {
      bindString(1, id)
      bindString(2, name)
      bindString(3, description)
      bindString(4, modified)
      bindString(5, resourceURI)
      bindString(6, thumbnailId)
    }
    notifyQueries(-1811368685, {database.marvelDatabaseQueries.selectAllCharacters +
        database.marvelDatabaseQueries.selectCharacterById})
  }

  override fun insertThumbnail(idThumb: String, path: String) {
    driver.execute(-2045031722, """
    |INSERT INTO Thumbnail_Entity(idThumb, path)
    |VALUES(?, ?)
    """.trimMargin(), 2) {
      bindString(1, idThumb)
      bindString(2, path)
    }
    notifyQueries(-2045031722, {database.marvelDatabaseQueries.selectAllCharacters})
  }

  override fun removeAllCharacters() {
    driver.execute(1269623786, """DELETE FROM Character_Entity""", 0)
    notifyQueries(1269623786, {database.marvelDatabaseQueries.selectAllCharacters +
        database.marvelDatabaseQueries.selectCharacterById})
  }

  override fun removeAllThumbnail() {
    driver.execute(-1578180756, """DELETE FROM Thumbnail_Entity""", 0)
    notifyQueries(-1578180756, {database.marvelDatabaseQueries.selectAllCharacters})
  }

  private inner class SelectCharacterByIdQuery<out T : Any>(
    @JvmField
    val id: String,
    mapper: (SqlCursor) -> T
  ) : Query<T>(selectCharacterById, mapper) {
    override fun execute(): SqlCursor = driver.executeQuery(-287812062, """
    |SELECT * FROM Character_Entity
    |WHERE id = ?
    """.trimMargin(), 1) {
      bindString(1, id)
    }

    override fun toString(): String = "MarvelDatabase.sq:selectCharacterById"
  }
}
