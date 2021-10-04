package droal.shareddb

import kotlin.String

data class Character_Entity(
  val id: String,
  val name: String,
  val description: String?,
  val modified: String?,
  val resourceURI: String?,
  val thumbnailId: String
) {
  override fun toString(): String = """
  |Character_Entity [
  |  id: $id
  |  name: $name
  |  description: $description
  |  modified: $modified
  |  resourceURI: $resourceURI
  |  thumbnailId: $thumbnailId
  |]
  """.trimMargin()
}
