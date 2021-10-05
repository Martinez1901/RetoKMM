package droal.shareddb

import kotlin.String

public data class Thumbnail_Entity(
  public val idThumb: String,
  public val path: String
) {
  public override fun toString(): String = """
  |Thumbnail_Entity [
  |  idThumb: $idThumb
  |  path: $path
  |]
  """.trimMargin()
}
