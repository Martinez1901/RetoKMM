package droal.shareddb

import kotlin.String

data class SelectAllCharacters(
  val id: String,
  val name: String,
  val description: String?,
  val modified: String?,
  val resourceURI: String?,
  val thumbnailId: String,
  val idThumb: String,
  val path: String
) {
  override fun toString(): String = """
  |SelectAllCharacters [
  |  id: $id
  |  name: $name
  |  description: $description
  |  modified: $modified
  |  resourceURI: $resourceURI
  |  thumbnailId: $thumbnailId
  |  idThumb: $idThumb
  |  path: $path
  |]
  """.trimMargin()
}
