import SwiftUI
import shared

struct DetailComicView: View {
    let comic: ComicShared
    
    var body: some View {
        ScrollView {
            VStack(spacing: 0) {
                CustomImageView(urlString: comic.thumbnailPath)
                
                Text(comic.title)
                    .font(.title)
                    .bold()
                    .padding()
                    .frame(minWidth: .zero, maxWidth: .infinity, minHeight: .zero, maxHeight: .infinity)
                    .background(Color("colorAccent"))
                    .foregroundColor(.white)
                
                Text("Description")
                    .font(.headline)
                    .frame(minWidth: .zero, maxWidth: .infinity, alignment: .leading)
                    .padding(.top)
                    .padding(.leading)
                Text(!comic.description_.isEmpty ? comic.description_ : "Description not found")
                    .font(.body)
                    .padding()
            }
        }
        .edgesIgnoringSafeArea(.top)
    }
}
