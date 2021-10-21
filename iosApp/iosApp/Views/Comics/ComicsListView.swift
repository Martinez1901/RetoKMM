import SwiftUI
import shared

struct ComicsListView: View {
    @Binding var isLoading: Bool
    @Binding var comics: [ComicShared]
    
    var body: some View {
        if isLoading {
            ProgressViewCustom()
                .padding(.top,50)
        }else{
            if(!comics.isEmpty){
                LazyVGrid(columns: [GridItem(),GridItem()]){
                    ForEach(comics, id: \.self) { comic in
                        NavigationLink(destination: DetailComicView(comic: comic)){
                            ComicItemView(comic: comic)
                        }.buttonStyle(PlainButtonStyle())
                    }
                }.padding()
            }else{
                TextEmptyView()
                    .padding()
            }            
        }
    }
}
