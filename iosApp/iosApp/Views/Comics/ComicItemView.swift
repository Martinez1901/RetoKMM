import SwiftUI
import shared

struct ComicItemView: View {
    let comic: ComicShared
    var body: some View {
        VStack(alignment: .center, content: {
            CustomImageView(urlString: comic.thumbnailPath)
                .frame(minWidth: .zero, maxWidth: .infinity, minHeight: .zero, maxHeight: .infinity, alignment: .center)
                .shadow(radius: 5)
            Text(comic.title)
                .fontWeight(.semibold)
                .foregroundColor(.black)
                .frame(minWidth: .zero, maxWidth: .infinity, alignment: .leading)
                .lineLimit(1)
        })
            .padding(.all)
    }
} 
