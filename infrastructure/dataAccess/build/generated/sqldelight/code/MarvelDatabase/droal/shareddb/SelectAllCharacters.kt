package droal.shareddb

import kotlin.String

public data class SelectAllCharacters(
  public val id: String,
  public val name: String,
  public val description: String?,
  public val modified: String?,
  public val resourceURI: String?,
  public val thumbnailId: String,
  public val idThumb: String,
  public val path: String
) {
  public override fun toString(): String = """
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
