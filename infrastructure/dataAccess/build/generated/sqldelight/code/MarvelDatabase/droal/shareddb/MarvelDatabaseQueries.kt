package droal.shareddb

import com.squareup.sqldelight.Query
import com.squareup.sqldelight.Transacter
import kotlin.Any
import kotlin.String

interface MarvelDatabaseQueries : Transacter {
  fun <T : Any> selectAllCharacters(mapper: (
    id: String,
    name: String,
    description: String?,
    modified: String?,
    resourceURI: String?,
    thumbnailId: String,
    idThumb: String,
    path: String
  ) -> T): Query<T>

  fun selectAllCharacters(): Query<SelectAllCharacters>

  fun <T : Any> selectCharacterById(id: String, mapper: (
    id: String,
    name: String,
    description: String?,
    modified: String?,
    resourceURI: String?,
    thumbnailId: String
  ) -> T): Query<T>

  fun selectCharacterById(id: String): Query<Character_Entity>

  fun insertCharacter(
    id: String,
    name: String,
    description: String?,
    modified: String?,
    resourceURI: String?,
    thumbnailId: String
  )

  fun insertThumbnail(idThumb: String, path: String)

  fun removeAllCharacters()

  fun removeAllThumbnail()
}
