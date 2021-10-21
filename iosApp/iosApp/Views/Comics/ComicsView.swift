import SwiftUI
import shared

struct ComicsView: View {
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
        ScrollView(.vertical) {
            ComicsListView(isLoading: $isLoading, comics: $comics)
        }
        .onAppear{
            viewModel = ComicsViewModel()
            viewModel?.comics.addObserver(observer: observer)
            viewModel?.getInformation(updateData: false)
        }
        .onDisappear{
            viewModel?.comics.removeObserver(observer: observer)
        }
    }
} 
