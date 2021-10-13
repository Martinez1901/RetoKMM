import SwiftUI
import shared

struct CharactersView: View {
    @State var viewModel : CharactersListViewModel? = nil
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
        VStack(alignment: .center, spacing: nil) {
            List {
                Title(title: "Characters")
                if isLoading {
                    Spacer()
                    ProgressViewCustom()
                }else{
                    if(!characters.isEmpty){
                        LazyVStack(){
                            ForEach(characters, id: \.self) { item in
                                CharacterView(data: item)
                            }
                        }
                    }else{
                        TextEmptyView()
                    }
                }
            }
            .listStyle(SidebarListStyle())
        }
        .onAppear {
            viewModel = CharactersListViewModel()
            viewModel?.characters.addObserver(observer: observer)
            viewModel?.getInformation(updateData: true)
        }
        .onDisappear{
            viewModel?.characters.removeObserver(observer: observer)
        }
    }
}

struct CharacterView: View {
    let data: CharacterShared
    var body: some View {
        HStack(alignment: .center, spacing: 20, content: {
            CustomImageView(urlString: data.thumbnailPath)
                .frame(minWidth: .zero, maxWidth: 80, minHeight: .zero, maxHeight: .infinity, alignment: .center)
                .clipShape(Circle())
            Text(data.name)
                .fontWeight(.semibold)
                .font(.system(size: 20))
                .frame(minWidth: .zero, maxWidth: .infinity, alignment: .leading)
        })
            .frame(minWidth: 0, maxWidth: .infinity, minHeight: 0, maxHeight: 80, alignment: .center)
    }
}

struct CharactersView_Previews: PreviewProvider {
    static var previews: some View {
        CharactersView()
    }
}
