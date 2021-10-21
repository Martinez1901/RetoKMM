import SwiftUI
import shared

struct CharactersView: View {
    @State var viewModel : CharactersViewModel? = nil
    @State var characters = [CharacterShared]()
    @State var isLoading = false
    
    var body: some View {
        let observer: (Resource<NSArray>?) -> Void = { (data) in
            guard let res = data else { return }
            switch res.status {
            case  Status.success :
                isLoading = false
                if let list = res.data {
                    characters = list as! [CharacterShared]
                }
            case Status.loading:
                isLoading = true
            case  Status.error :
                isLoading = false
            default:
                isLoading = false
            }
        }
        ScrollView(.vertical) {
            CharacterListView(isLoading: $isLoading, characters: $characters)
        }
        .onAppear {
            viewModel = CharactersViewModel()
            viewModel?.characters.addObserver(observer: observer)
            viewModel?.getInformation(updateData: false)
        }
        .onDisappear{
            viewModel?.characters.removeObserver(observer: observer)
        }
    }
}
