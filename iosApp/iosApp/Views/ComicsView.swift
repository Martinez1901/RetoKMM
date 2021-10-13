import SwiftUI
import shared

struct ComicsView: View {
    @State var viewModel: ComicsListViewModel? = nil
    @State var comics = [ComicShared]()
    @State var presentingModal = false
    @State var isLoading = false
    
    var body: some View {
        let observer:(Resource<NSArray>?)->Void = { (data) in
            guard let res = data else { return }
            switch res.status {
            case  Status.success :
                isLoading = false
                if let list = res.data {
                    comics = list as! [ComicShared]
                }
            case  Status.loading :
                isLoading = true
            case  Status.error :
                isLoading = false
            default:
                isLoading = false
            }
        }
        VStack(alignment: .center, spacing: nil) {
            List {
                Title(title: "Comics")
                if isLoading {
                    Spacer()
                    ProgressViewCustom()
                }else{
                    if(!comics.isEmpty){
                        LazyVGrid(columns: [GridItem(),GridItem()]){
                            ForEach(comics, id: \.self) { comic in
                                ComicView(comic: comic)
                                    .onTapGesture {
                                        presentingModal.toggle()
                                    }
                            }
                        }
                    }else{
                        TextEmptyView()
                    }
                }
            }
            .listRowInsets(EdgeInsets())
            .listStyle(SidebarListStyle())
        }
//        .fullScreenCover(isPresented: $presentingModal, content: {
//            //            DetailView()
//        })
        .onAppear{
            viewModel = ComicsListViewModel()
            viewModel?.comics.addObserver(observer: observer)
            viewModel?.getInformation(updateData: false)
        }
        .onDisappear{
            viewModel?.comics.removeObserver(observer: observer)
        }
    }
}

struct ComicView: View {
    let comic: ComicShared
    var body: some View {
        VStack(alignment: .center, content: {
            CustomImageView(urlString: comic.thumbnailPath)
                .frame(minWidth: .zero, maxWidth: .infinity, minHeight: .zero, maxHeight: .infinity, alignment: .center)
            Text(comic.title)
                .fontWeight(.semibold)
                .frame(minWidth: .zero, maxWidth: .infinity, alignment: .leading)
                .lineLimit(1)
        })
            .padding(.all)
    }
}
