import SwiftUI
import AlertToast
import shared

struct SearchComicsView: View {
    @State private var searchText = ""
    @State private var showToast = false
    @State private var msgToast = ""
    @State var viewModel: ComicsViewModel? = nil
    @State var comics = [ComicShared]()
    @State var isLoading = false
    
    var body: some View {
        let observer:(Resource<NSArray>?)->Void = { (data) in
            guard let res = data else { return }
            switch res.status {
            case  Status.success :
                isLoading = false
                if let list = res.data {
                    if (list.count==0) {
                        msgToast = "Comic not found"
                        showToast.toggle()
                    } else{
                        comics = list as! [ComicShared]
                    }
                }
            case  Status.loading :
                isLoading = true
            case  Status.error :
                isLoading = false
            default:
                isLoading = false
            }
        }
        ScrollView(.vertical) {
            VStack(spacing: 0){
                TextFielSearch(searchText: $searchText, msgToast: $msgToast, showToast: $showToast){ 
                    viewModel?.searchComics(comicTitle: searchText)
                }
                ComicsListView(isLoading: $isLoading, comics: $comics)
                    .padding(.top)
            }
            .padding()
        }
        .onAppear{
            viewModel = ComicsViewModel()
            viewModel?.comics.addObserver(observer: observer)
            isLoading.toggle()
        }
        .onDisappear{
            viewModel?.comics.removeObserver(observer: observer)
        }
        .toast(isPresenting: $showToast){
            AlertToast(type: .regular, title: msgToast)
        }
    }
} 
