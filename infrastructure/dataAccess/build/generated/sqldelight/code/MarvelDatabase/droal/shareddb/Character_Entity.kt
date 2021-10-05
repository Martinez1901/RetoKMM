package droal.shareddb

import kotlin.String

public data class Character_Entity(
  public val id: String,
  public val name: String,
  public val description: String?,
  public val modified: String?,
  public val resourceURI: String?,
  public val thumbnailId: String
) {
  public override fun toString(): String = """
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
