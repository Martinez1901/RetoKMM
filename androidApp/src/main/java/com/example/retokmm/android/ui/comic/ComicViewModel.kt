package com.example.retokmm.android.ui.comic

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.Serializable

class ComicViewModel: ViewModel() {

    val listComics = MutableLiveData<List<Comic>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            delay(1000)
            listComics.postValue(listComics())
            isLoading.postValue(false)
        }
    }

    fun listComics(): List<Comic> {
        return listOf(
            Comic(
                1,
                "Superman",
                thumbnailPath = "http://i.annihil.us/u/prod/marvel/i/mg/d/03/6151f9130899b",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed hendrerit posuere augue, id euismod nulla ornare sed. Phasellus vel commodo felis, quis ultrices massa. Proin elit tortor, varius ac sapien sit amet, semper sollicitudin arcu. Vestibulum suscipit gravida ligula, et rhoncus massa tincidunt sit amet. Cras nec pulvinar leo. Duis nec mi vel ante pulvinar laoreet blandit et est. Nullam id eros ut magna volutpat euismod in eu est. In vitae elit aliquet, egestas ante vel, finibus est. Ut purus metus, aliquet in congue sed, pretium in nisl. Integer at rutrum turpis. Integer in aliquam nunc, at placerat magna. Duis sagittis pellentesque fermentum. Ut non metus auctor ipsum ultricies feugiat id nec eros. Maecenas id velit urna. Duis sit amet erat justo.\n" +
                        "\n" +
                        "Praesent sed lacus posuere, vulputate eros non, iaculis eros. Vestibulum in feugiat libero, vel vulputate velit. Donec arcu ligula, dictum vitae semper vitae, imperdiet eget magna. Maecenas nec sodales tellus. Nam vitae justo aliquam, consectetur justo in, euismod enim. Morbi ac est eget lorem dignissim porttitor. Nulla velit ex, fringilla non purus in, tincidunt pretium nunc."
            ),
            Comic(
                2,
                "Spider Man",
                thumbnailPath = "http://i.annihil.us/u/prod/marvel/i/mg/c/80/5e3d7536c8ada",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed hendrerit posuere augue, id euismod nulla ornare sed. Phasellus vel commodo felis, quis ultrices massa. Proin elit tortor, varius ac sapien sit amet, semper sollicitudin arcu. Vestibulum suscipit gravida ligula, et rhoncus massa tincidunt sit amet. Cras nec pulvinar leo. Duis nec mi vel ante pulvinar laoreet blandit et est. Nullam id eros ut magna volutpat euismod in eu est. In vitae elit aliquet, egestas ante vel, finibus est. Ut purus metus, aliquet in congue sed, pretium in nisl. Integer at rutrum turpis. Integer in aliquam nunc, at placerat magna. Duis sagittis pellentesque fermentum. Ut non metus auctor ipsum ultricies feugiat id nec eros. Maecenas id velit urna. Duis sit amet erat justo.\n" +
                        "\n" +
                        "Praesent sed lacus posuere, vulputate eros non, iaculis eros. Vestibulum in feugiat libero, vel vulputate velit. Donec arcu ligula, dictum vitae semper vitae, imperdiet eget magna. Maecenas nec sodales tellus. Nam vitae justo aliquam, consectetur justo in, euismod enim. Morbi ac est eget lorem dignissim porttitor. Nulla velit ex, fringilla non purus in, tincidunt pretium nunc."
            ),
            Comic(
                3,
                "Iron Man",
                thumbnailPath = "http://i.annihil.us/u/prod/marvel/i/mg/9/20/4bc665483c3aa",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed hendrerit posuere augue, id euismod nulla ornare sed. Phasellus vel commodo felis, quis ultrices massa. Proin elit tortor, varius ac sapien sit amet, semper sollicitudin arcu. Vestibulum suscipit gravida ligula, et rhoncus massa tincidunt sit amet. Cras nec pulvinar leo. Duis nec mi vel ante pulvinar laoreet blandit et est. Nullam id eros ut magna volutpat euismod in eu est. In vitae elit aliquet, egestas ante vel, finibus est. Ut purus metus, aliquet in congue sed, pretium in nisl. Integer at rutrum turpis. Integer in aliquam nunc, at placerat magna. Duis sagittis pellentesque fermentum. Ut non metus auctor ipsum ultricies feugiat id nec eros. Maecenas id velit urna. Duis sit amet erat justo.\n" +
                        "\n" +
                        "Praesent sed lacus posuere, vulputate eros non, iaculis eros. Vestibulum in feugiat libero, vel vulputate velit. Donec arcu ligula, dictum vitae semper vitae, imperdiet eget magna. Maecenas nec sodales tellus. Nam vitae justo aliquam, consectetur justo in, euismod enim. Morbi ac est eget lorem dignissim porttitor. Nulla velit ex, fringilla non purus in, tincidunt pretium nunc."
            ),
            Comic(
                4,
                "Acuaman",
                thumbnailPath = "http://i.annihil.us/u/prod/marvel/i/mg/9/30/4bc64df4105b9",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed hendrerit posuere augue, id euismod nulla ornare sed. Phasellus vel commodo felis, quis ultrices massa. Proin elit tortor, varius ac sapien sit amet, semper sollicitudin arcu. Vestibulum suscipit gravida ligula, et rhoncus massa tincidunt sit amet. Cras nec pulvinar leo. Duis nec mi vel ante pulvinar laoreet blandit et est. Nullam id eros ut magna volutpat euismod in eu est. In vitae elit aliquet, egestas ante vel, finibus est. Ut purus metus, aliquet in congue sed, pretium in nisl. Integer at rutrum turpis. Integer in aliquam nunc, at placerat magna. Duis sagittis pellentesque fermentum. Ut non metus auctor ipsum ultricies feugiat id nec eros. Maecenas id velit urna. Duis sit amet erat justo.\n" +
                        "\n" +
                        "Praesent sed lacus posuere, vulputate eros non, iaculis eros. Vestibulum in feugiat libero, vel vulputate velit. Donec arcu ligula, dictum vitae semper vitae, imperdiet eget magna. Maecenas nec sodales tellus. Nam vitae justo aliquam, consectetur justo in, euismod enim. Morbi ac est eget lorem dignissim porttitor. Nulla velit ex, fringilla non purus in, tincidunt pretium nunc."
            ),
            Comic(
                5,
                "Hulk",
                thumbnailPath = "http://i.annihil.us/u/prod/marvel/i/mg/4/20/4bc697c680890",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed hendrerit posuere augue, id euismod nulla ornare sed. Phasellus vel commodo felis, quis ultrices massa. Proin elit tortor, varius ac sapien sit amet, semper sollicitudin arcu. Vestibulum suscipit gravida ligula, et rhoncus massa tincidunt sit amet. Cras nec pulvinar leo. Duis nec mi vel ante pulvinar laoreet blandit et est. Nullam id eros ut magna volutpat euismod in eu est. In vitae elit aliquet, egestas ante vel, finibus est. Ut purus metus, aliquet in congue sed, pretium in nisl. Integer at rutrum turpis. Integer in aliquam nunc, at placerat magna. Duis sagittis pellentesque fermentum. Ut non metus auctor ipsum ultricies feugiat id nec eros. Maecenas id velit urna. Duis sit amet erat justo.\n" +
                        "\n" +
                        "Praesent sed lacus posuere, vulputate eros non, iaculis eros. Vestibulum in feugiat libero, vel vulputate velit. Donec arcu ligula, dictum vitae semper vitae, imperdiet eget magna. Maecenas nec sodales tellus. Nam vitae justo aliquam, consectetur justo in, euismod enim. Morbi ac est eget lorem dignissim porttitor. Nulla velit ex, fringilla non purus in, tincidunt pretium nunc."
            ),
            Comic(
                6,
                "Capitan America",
                thumbnailPath = "http://i.annihil.us/u/prod/marvel/i/mg/f/20/4bc63a47b8dcb",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed hendrerit posuere augue, id euismod nulla ornare sed. Phasellus vel commodo felis, quis ultrices massa. Proin elit tortor, varius ac sapien sit amet, semper sollicitudin arcu. Vestibulum suscipit gravida ligula, et rhoncus massa tincidunt sit amet. Cras nec pulvinar leo. Duis nec mi vel ante pulvinar laoreet blandit et est. Nullam id eros ut magna volutpat euismod in eu est. In vitae elit aliquet, egestas ante vel, finibus est. Ut purus metus, aliquet in congue sed, pretium in nisl. Integer at rutrum turpis. Integer in aliquam nunc, at placerat magna. Duis sagittis pellentesque fermentum. Ut non metus auctor ipsum ultricies feugiat id nec eros. Maecenas id velit urna. Duis sit amet erat justo.\n" +
                        "\n" +
                        "Praesent sed lacus posuere, vulputate eros non, iaculis eros. Vestibulum in feugiat libero, vel vulputate velit. Donec arcu ligula, dictum vitae semper vitae, imperdiet eget magna. Maecenas nec sodales tellus. Nam vitae justo aliquam, consectetur justo in, euismod enim. Morbi ac est eget lorem dignissim porttitor. Nulla velit ex, fringilla non purus in, tincidunt pretium nunc."
            ),
        )
    }
}

data class Comic(
    val id: Int,
    val name: String,
    val description: String = "",
    val thumbnailPath: String,
): Serializable