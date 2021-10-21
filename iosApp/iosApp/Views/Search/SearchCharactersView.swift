import SwiftUI
import AlertToast
import shared

struct SearchCharactersView: View {
    @State private var searchText = ""
    @State private var showToast = false
    @State private var msgToast = ""
    @State var viewModel: CharactersViewModel? = nil
    @State var characters = [CharacterShared]()
    @State var isLoading = false
    
    var body: some View {
        let observer:(Resource<NSArray>?)->Void = { (data) in
            guard let res = data else { return }
            switch res.status {
            case  Status.success :
                isLoading = false
                if let list = res.data {
                    if (list.count==0) {
                        msgToast = "Character not found"
                        showToast.toggle()
                    } else{
                        characters = list as! [CharacterShared]
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
                    viewModel?.searchCharacter(characterTitle: searchText)
                }
                CharacterListView(isLoading: $isLoading, characters: $characters)
                    .padding(.top)
            }
            .padding()
        }
        .onAppear{
            viewModel = CharactersViewModel()
            viewModel?.characters.addObserver(observer: observer)
            isLoading.toggle()
        }
        .onDisappear{
            viewModel?.characters.removeObserver(observer: observer)
        }
        .toast(isPresenting: $showToast){
            AlertToast(type: .regular, title: msgToast)
        }
    }
}
