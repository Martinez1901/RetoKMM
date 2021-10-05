package droal.shareddb

import com.squareup.sqldelight.Query
import com.squareup.sqldelight.Transacter
import kotlin.Any
import kotlin.String
import kotlin.Unit

public interface MarvelDatabaseQueries : Transacter {
  public fun <T : Any> selectAllCharacters(mapper: (
    id: String,
    name: String,
    description: String?,
    modified: String?,
    resourceURI: String?,
    thumbnailId: String,
    idThumb: String,
    path: String
  ) -> T): Query<T>

  public fun selectAllCharacters(): Query<SelectAllCharacters>

  public fun <T : Any> selectCharacterById(id: String, mapper: (
    id: String,
    name: String,
    description: String?,
    modified: String?,
    resourceURI: String?,
    thumbnailId: String
  ) -> T): Query<T>

  public fun selectCharacterById(id: String): Query<Character_Entity>

  public fun insertCharacter(
    id: String,
    name: String,
    description: String?,
    modified: String?,
    resourceURI: String?,
    thumbnailId: String
  ): Unit

  public fun insertThumbnail(idThumb: String, path: String): Unit

  public fun removeAllCharacters(): Unit

  public fun removeAllThumbnail(): Unit
}
