package droal.shareddb

import kotlin.String

data class Thumbnail_Entity(
  val idThumb: String,
  val path: String
) {
  override fun toString(): String = """
  |Thumbnail_Entity [
  |  idThumb: $idThumb
  |  path: $path
  |]
  """.trimMargin()
}
